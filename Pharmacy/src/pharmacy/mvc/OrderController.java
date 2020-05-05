package pharmacy.mvc;

import static java.util.stream.Collectors.toList;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pharmacy.entity.Employee;
import pharmacy.entity.Order;
import pharmacy.entity.OrderMedicament;
import pharmacy.service.EmployeeService;
import pharmacy.service.OrderMedicamentService;
import pharmacy.service.OrderService;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;
    
    @Autowired
    private EmployeeService employeeService;
    
    @Autowired
    private OrderMedicamentService orderMedService;
    
    @GetMapping("/orders.html")
    public String orders(Model model) {
        List<Order> orders = orderService.getAll().stream().collect(toList());
        model.addAttribute("orders", orders);
        return "orders";
    }
    
    @GetMapping("/order.html")
    public String order(@RequestParam("id") Long id, Model model) {
        model.addAttribute("order", orderService.getById(id));
        List<OrderMedicament> meds = orderMedService.findAllByOrder(id).stream().collect(toList());
        model.addAttribute("orderMeds", meds);
        return "order";
    }
    
    @GetMapping("/deleteOrder.html")
    public String delete(@RequestParam("id") Long id) {
        if (id != null) {
            orderService.deleteById(id);
        }
        return "redirect:/orders.html";
    }
    
    @GetMapping("/goAddOrder.html")
    public String goToAddOrder(@RequestParam("id") Long id, @RequestParam("pendingOrder") Long pendingOrder, Model model) throws ParseException {
        if (id != -1) {
            model.addAttribute("orders", orderService.getById(id));
        }
        
        //Date date = Calendar.getInstance().getTime();
        //Date dateNow = new SimpleDateFormat("yyyy-MM-dd").parse(new String(date.toString()));
        List<Employee> empls = employeeService.getByPosition("Фармацевт");
        //List<Medicament> meds = medicamentService.findByManufacturability("1");
        model.addAttribute("empls", empls);
        //model.addAttribute("dateNow", dateNow);
        model.addAttribute("pendingOrder", pendingOrder);
        //model.addAttribute("meds", meds);
        return "editOrder";
    }

    @RequestMapping(value = "/orderAdd.html", method = {RequestMethod.GET, RequestMethod.POST})
    public String edit(@ModelAttribute Order order, Model model, @RequestParam("pendingOrder") Long pendingOrder) throws UnsupportedEncodingException{
        ArrayList<String> errors = orderService.check(order);
        
        List<Employee> empls = employeeService.getByPosition("Фармацевт");
        
        for(String list: errors) {
            System.out.println(list);
        }
        if (errors.size() != 0)
        {
            model.addAttribute("errors", errors);
            model.addAttribute("orders", order);
            model.addAttribute("pendingOrder", pendingOrder);
            model.addAttribute("empls", empls);
            return "editOrder";
        } else 
        {
            try {
                orderService.add(order);
            } catch (Exception e) {
               
                errors.add("Ошибка: " + e.getMessage());
                
                model.addAttribute("errors", errors);
                model.addAttribute("orders", order);
                model.addAttribute("pendingOrder", pendingOrder);
                model.addAttribute("empls", empls);
                return "editOrder";
            }
        }
        if(pendingOrder == 1) {
            return "redirect:/goAddPendingOrder.html?id=-1";
        } 
        else return "redirect:/orders.html";
    }
}

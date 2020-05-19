package pharmacy.mvc;

import static java.util.stream.Collectors.toList;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pharmacy.entity.Client;
import pharmacy.entity.Employee;
import pharmacy.entity.Order;
import pharmacy.entity.OrderMedicament;
import pharmacy.service.ClientService;
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
    private ClientService clientService;

    @Autowired
    private OrderMedicamentService orderMedService;

    @PreAuthorize("hasRole('ROLE_PHARMACIST')")
    @GetMapping("/orders.html")
    public String orders(Model model) {
        List<Order> orders = orderService.getAll().stream().collect(toList());
        model.addAttribute("orders", orders);
        return "orders";
    }

    @PreAuthorize("hasRole('ROLE_PHARMACIST')")
    @GetMapping("/order.html")
    public String order(@RequestParam("id") Long id, Model model) {
        model.addAttribute("order", orderService.getById(id));
        List<OrderMedicament> meds = orderMedService.findAllByOrder(id).stream().collect(toList());
        model.addAttribute("orderMeds", meds);
        return "order";
    }

    @PreAuthorize("hasRole('ROLE_PHARMACIST')")
    @GetMapping("/deleteOrder.html")
    public String delete(@RequestParam("id") Long id) {
        if (id != null) {
            orderService.deleteById(id);
        }
        return "redirect:/orders.html";
    }

    @PreAuthorize("hasRole('ROLE_PHARMACIST')")
    @GetMapping("/goAddOrder.html")
    public String goToAddOrder(@RequestParam("id") Long id, @RequestParam("pendingOrder") Long pendingOrder, Model model)
            throws ParseException {
        if (id != -1) {
            model.addAttribute("orders", orderService.getById(id));
        }

        List<Employee> empls = employeeService.getByPosition("Фармацевт");
        model.addAttribute("empls", empls);
        List<Client> clients = clientService.getClients();
        model.addAttribute("clients", clients);

        model.addAttribute("pendingOrder", pendingOrder);
        return "editOrder";
    }

    @PreAuthorize("hasRole('ROLE_PHARMACIST')")
    @RequestMapping(value = "/orderAdd.html", method = { RequestMethod.GET, RequestMethod.POST })
    public String edit(@ModelAttribute Order order, Model model, @RequestParam("pendingOrder") Long pendingOrder)
            throws UnsupportedEncodingException {
        ArrayList<String> errors = orderService.check(order);

        List<Employee> empls = employeeService.getByPosition("Фармацевт");
        List<Client> clients = clientService.getClients();

        for (String list : errors) {
            System.out.println(list);
        }
        if (errors.size() != 0) {
            model.addAttribute("errors", errors);
            model.addAttribute("orders", order);
            model.addAttribute("pendingOrder", pendingOrder);
            model.addAttribute("empls", empls);
            model.addAttribute("clients", clients);
            return "editOrder";
        } else {
            try {
                orderService.add(order);
            } catch (Exception e) {

                errors.add("Ошибка: " + e.getMessage());

                model.addAttribute("errors", errors);
                model.addAttribute("orders", order);
                model.addAttribute("pendingOrder", pendingOrder);
                model.addAttribute("empls", empls);
                model.addAttribute("clients", clients);
                return "editOrder";
            }
        }
        if (pendingOrder == 1) {
            Long idEmpl = order.getEmployee().getId();
            return "redirect:/goFindOrder.html?idEmpl=" + idEmpl;
            // return "redirect:/goAddPendingOrder.html?id=-1&idOrder=";
        } else
            return "redirect:/orders.html";
    }

    @PreAuthorize("hasRole('ROLE_PHARMACIST')")
    @GetMapping("/goFindOrder.html")
    public String goFindOrder(@RequestParam("idEmpl") Long idEmpl, Model model) {
        Order order = orderService.findByEmpl(idEmpl);
        Long idOrder = order.getId();
        return "redirect:/goAddPendingOrder.html?id=-1&idOrder=" + idOrder;
    }
}

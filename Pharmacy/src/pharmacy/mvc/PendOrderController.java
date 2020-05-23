package pharmacy.mvc;

import static java.util.stream.Collectors.toList;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
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

import pharmacy.common.OrderCostInfo;
import pharmacy.entity.Employee;
import pharmacy.entity.OrderMedicament;
import pharmacy.entity.PendingOrder;
import pharmacy.service.EmployeeService;
import pharmacy.service.OrderMedicamentService;
import pharmacy.service.PendingOrderService;

@Controller
public class PendOrderController {

    @Autowired
    private PendingOrderService pendOrderService;
    
    @Autowired
    private EmployeeService employeeService;
    
    @Autowired
    private OrderMedicamentService orderMedService;
    
    @PreAuthorize("hasRole('ROLE_PHARMACIST')")
    @GetMapping("/pendingOrders.html")
    public String pendingOrders(Model model) {
        List<PendingOrder> pendOrders = pendOrderService.getAll().stream().collect(toList());
        model.addAttribute("pendOrders", pendOrders);
        return "pendingOrders";
    }
    
    @PreAuthorize("hasRole('ROLE_PHARMACIST')")
    @GetMapping("/pendingOrder.html")
    public String pendingOrder(@RequestParam("id") Long id, Model model) {
        model.addAttribute("pendingOrder", pendOrderService.getById(id));
        Long idOrder = pendOrderService.getById(id).getOrder().getId();
        List<OrderMedicament> meds = orderMedService.findAllByOrder(idOrder).stream().collect(toList());
        List<OrderCostInfo> medCost = orderMedService.getOrderCostInfo(idOrder).stream().collect(toList());
        BigDecimal cost = orderMedService.getCostByInfo(medCost);
        model.addAttribute("costAll", cost);
        model.addAttribute("orderMeds", meds);
        model.addAttribute("medCosts", medCost);
        return "pendingOrder";
    }
    
    @PreAuthorize("hasRole('ROLE_PHARMACIST')")
    @GetMapping("/deletePendingOrder.html")
    public String delete(@RequestParam("id") Long id) {
        if (id != null) {
            pendOrderService.deleteById(id);
        }
        return "redirect:/pendingOrders.html";
    }
    
    @PreAuthorize("hasRole('ROLE_PHARMACIST')")
    @GetMapping("/goAddPendingOrder.html")
    public String goToAddPendingOrder(@RequestParam("id") Long id, @RequestParam("idOrder") Long idOrder, Model model) {
        if (id != -1) {
            model.addAttribute("pendingOrders", pendOrderService.getById(id));
        }
        model.addAttribute("idOrder", idOrder);
        List<Employee> empls = employeeService.getByPosition("Провизор-технолог");
        model.addAttribute("empls", empls);
        return "editPendOrder";
    }
    
    @PreAuthorize("hasRole('ROLE_PHARMACIST')")
    @GetMapping("/goAddPO.html")
    public String goToAddPO(Model model) {
        return "redirect:/goAddOrder.html?pendingOrder=1&id=-1";
    }

    @PreAuthorize("hasRole('ROLE_PHARMACIST')")
    @RequestMapping(value = "/pendingOrderAdd.html", method = {RequestMethod.GET, RequestMethod.POST})
    public String edit(@ModelAttribute PendingOrder pendingOrder, Model model) throws UnsupportedEncodingException{
        ArrayList<String> errors = pendOrderService.check(pendingOrder);
        List<Employee> empls = employeeService.getByPosition("Провизор-технолог");
        
        
        for(String list: errors) {
            System.out.println(list);
        }
        if (errors.size() != 0)
        {
            model.addAttribute("errors", errors);
            model.addAttribute("pendingOrders", pendingOrder);
            model.addAttribute("empls", empls);
            return "editPendOrder";
        } else 
        {
            try {
                pendOrderService.add(pendingOrder);
            } catch (Exception e) {
               
                errors.add("Ошибка: " + e.getMessage());
                
                model.addAttribute("errors", errors);
                model.addAttribute("pendingOrders", pendingOrder);
                model.addAttribute("empls", empls);
                return "editPendOrder";
            }
        }
        
        Long idO = pendingOrder.getOrder().getId();
        //return "redirect:/pendingOrders.html";
        return "redirect:/po.html?idO="+idO;
    }
    
    @PreAuthorize("hasRole('ROLE_PHARMACIST')")
    @GetMapping("/po.html")
    public String po(@RequestParam("idO") Long idO, Model model) {
         PendingOrder po = pendOrderService.getByIdOrder(idO);
         Long id = po.getId();
        return "redirect:/pendingOrder.html?id="+id+"&idOrder="+idO;
    }
}

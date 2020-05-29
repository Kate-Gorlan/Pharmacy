package pharmacy.mvc;

import java.io.UnsupportedEncodingException;
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

import pharmacy.entity.Medicament;
import pharmacy.entity.OrderMedicament;
import pharmacy.entity.Prescription;
import pharmacy.service.MedicamentService;
import pharmacy.service.OrderMedicamentService;
import pharmacy.service.PendingOrderService;
import pharmacy.service.PrescriptionService;

@Controller
public class MedOrderController {

    @Autowired
    private OrderMedicamentService orderMedService;
    
    @Autowired
    private PendingOrderService pendingOrderService;
    
    @Autowired
    private MedicamentService medicamentService;
    
    @Autowired
    private PrescriptionService prescriptionService;
    
    
    
    @PreAuthorize("hasRole('ROLE_PHARMACIST')")
    @GetMapping("/deleteOrderMed.html")
    public String delete(@RequestParam("id") Long id, @RequestParam("pendingOrderId") Long pendingOrderId) {
        if (id != null) {
            orderMedService.deleteById(id);
        }
        Long idOrder = (long) 0;
        if (pendingOrderId != null) {
        idOrder = pendingOrderService.getById(pendingOrderId).getOrder().getId();
        }
        return "redirect:/pendingOrder.html?id="+pendingOrderId+"&idOrder="+idOrder;
    }
    
    @PreAuthorize("hasRole('ROLE_PHARMACIST')")
    @GetMapping("/goAddOrderMed.html")
    public String goToAddOrderMed(@RequestParam("id") Long id, @RequestParam("pendingOrderId") Long pendingOrderId, Model model) {
        List<Prescription> prs = prescriptionService.getNew();
        if (id != -1) {
            prs = prescriptionService.getAll();
            model.addAttribute("oms", orderMedService.getById(id));
        }
        model.addAttribute("pendingOrderId", pendingOrderId);
        
        List<Medicament> meds = medicamentService.getAll();
        
        model.addAttribute("meds", meds);
        model.addAttribute("prs", prs);
        
        Long idOrder = pendingOrderService.getById(pendingOrderId).getOrder().getId();
        model.addAttribute("orderID", idOrder);
        
        return "editOrderMedicament";
    }

    @PreAuthorize("hasRole('ROLE_PHARMACIST')")
    @RequestMapping(value = "/orderMedAdd.html", method = {RequestMethod.GET, RequestMethod.POST})
    public String edit(@ModelAttribute OrderMedicament om, Model model, 
            @RequestParam("pendingOrderId") Long pendingOrderId) throws UnsupportedEncodingException{
        
        ArrayList<String> errors = orderMedService.check(om);
        
        List<Medicament> meds = medicamentService.getAll();
        List<Prescription> prs = prescriptionService.getAll();
        Long idOrder = pendingOrderService.getById(pendingOrderId).getOrder().getId();
        
        
        for(String list: errors) {
            System.out.println(list);
        }
        if (errors.size() != 0)
        {
            model.addAttribute("errors", errors);
            model.addAttribute("oms", om);
            model.addAttribute("meds", meds);
            model.addAttribute("prs", prs);
            model.addAttribute("orderID", idOrder);
            model.addAttribute("pendingOrderId", pendingOrderId);
            return "editOrderMedicament";
        } else 
        {
            try {
                orderMedService.add(om);
            } catch (Exception e) {
               
                errors.add("Ошибка: " + e.getMessage());
                
                model.addAttribute("errors", errors);
                model.addAttribute("oms", om);
                model.addAttribute("meds", meds);
                model.addAttribute("prs", prs);
                model.addAttribute("orderID", idOrder);
                model.addAttribute("pendingOrderId", pendingOrderId);
                return "editOrderMedicament";
            }
        }
        
        //return "redirect:/pendingOrders.html";
        Long Order = (long) 0;
        if (pendingOrderId != null) {
            Order = pendingOrderService.getById(pendingOrderId).getOrder().getId();
            }
            return "redirect:/pendingOrder.html?id="+pendingOrderId+"&idOrder="+Order;
    }

}

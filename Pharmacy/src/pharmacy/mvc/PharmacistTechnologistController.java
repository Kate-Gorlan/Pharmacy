package pharmacy.mvc;

import static java.util.stream.Collectors.toList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pharmacy.common.PendingOrderEmployee;
import pharmacy.service.PendingOrderService;

@Controller
public class PharmacistTechnologistController {

    @Autowired
    private PendingOrderService pendingOrderService;
    
    @GetMapping("/pharmacistTechnologist.html")
    public String storekeeper(Model model) {
        //---------
        long id = 4;
        //---------
        
        List<PendingOrderEmployee> medsForManufacture = pendingOrderService.findByEmployee(id).stream().collect(toList());
        model.addAttribute("medsForManufacture", medsForManufacture);
        
        return "pharmacistTechnologist";  
    }
}

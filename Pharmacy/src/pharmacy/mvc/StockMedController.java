package pharmacy.mvc;

import static java.util.stream.Collectors.toList;

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
import pharmacy.entity.MedicamentStock;
import pharmacy.service.MedicamentService;
import pharmacy.service.MedicamentStockService;
import pharmacy.service.ProductStockService;

@Controller
public class StockMedController {

    @Autowired
    private MedicamentStockService medicamentStockService;
    
    @Autowired
    private ProductStockService productStockService;
    
    @Autowired
    private MedicamentService medicamentService;

    @PreAuthorize("hasRole('ROLE_STOREKEEPER')")
    @GetMapping("/stockMedicaments.html")
    public String stockMedicaments(Model model) {
        List<MedicamentStock> listChoose = medicamentStockService.getAll().stream().collect(toList());
        List<MedicamentStock> expired = medicamentStockService.getMedicamentThatHaveExpired().stream().collect(toList());
        List<MedicamentStock> willSoonExpire = medicamentStockService.getMedicamentThatWillSoonExpire().stream().collect(toList());
        
        model.addAttribute("medStock", listChoose);
        model.addAttribute("medExpired", expired);
        model.addAttribute("medWillSoonExpire", willSoonExpire);
        return "stockMedicaments";
    }

    @PreAuthorize("hasRole('ROLE_STOREKEEPER')")
    @GetMapping("/deleteStockMedicament.html")
    public String delete(@RequestParam("id") Long id) {
        if (id != null) {
            medicamentStockService.deleteById(id);
        }
        return "redirect:/stockMedicaments.html";
    }
    
   
    @PreAuthorize("hasRole('ROLE_PHARMACIST') "
            + "|| hasRole('ROLE_STOREKEEPER')")
    @GetMapping("/goAddStockMedicament.html")
    public String goToAddStockMedicament(@RequestParam("id") Long id, Model model) {
        if (id != -1) {
            model.addAttribute("medicamentStocks", medicamentStockService.getById(id));
        }
        
        List<Medicament> meds = medicamentService.getAll();
        model.addAttribute("meds", meds);
        return "editStockMedicament";
    }

    @PreAuthorize("hasRole('ROLE_PHARMACIST') "
            + "|| hasRole('ROLE_STOREKEEPER')")
    @RequestMapping(value = "/stockMedicamentAdd.html", method = {RequestMethod.GET, RequestMethod.POST})
    public String edit(@ModelAttribute MedicamentStock medicamentStock, @RequestParam("page") Long page, Model model) throws UnsupportedEncodingException{
        ArrayList<String> errors = medicamentStockService.check(medicamentStock);
        
        for(String list: errors) {
            System.out.println(list);
        }
        if (errors.size() != 0)
        {
            model.addAttribute("errors", errors);
            model.addAttribute("medicamentStocks", medicamentStock);
            List<Medicament> meds = medicamentService.getAll();
            model.addAttribute("meds", meds);
            if (page == 1) return "editStockMedicament";
            else return "addSMForTechnologist";
        } else 
        {
            try {
            medicamentStockService.add(medicamentStock);
            if (page == 2) {
            Long idM = medicamentStock.getMedicament().getId();
            String medName = medicamentService.getById(idM).getName();
            productStockService.delProds(medName);
            
            }
            } catch (Exception e) {
   
                errors.add("Ошибка: " + e.getMessage());
                
                model.addAttribute("errors", errors);
                model.addAttribute("medicamentStocks", medicamentStock);
                List<Medicament> meds = medicamentService.getAll();
                model.addAttribute("meds", meds);
                if (page == 1) return "editStockMedicament";
                else return "addSMForTechnologist";
            }
        }
        if (page == 1)
            return "redirect:/stockMedicaments.html";
        else return "redirect:/pharmacistTechnologist.html";
    }
}

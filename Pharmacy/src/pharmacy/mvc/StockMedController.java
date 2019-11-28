package pharmacy.mvc;

import static java.util.stream.Collectors.toList;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pharmacy.entity.MedicamentStock;
import pharmacy.service.MedicamentStockService;

@Controller
public class StockMedController {

    @Autowired
    private MedicamentStockService medicamentStockService;

    @GetMapping("/stockMedicaments.html")
    public String stockMedicaments(Model model) {
        List<MedicamentStock> listChoose = medicamentStockService.getAll().stream().collect(toList());
        model.addAttribute("medStock", listChoose);
        return "stockMedicaments";
    }

    @GetMapping("/deleteStockMedicament.html")
    public String delete(@RequestParam("id") Long id) {
        if (id != null) {
            medicamentStockService.deleteById(id);
        }
        return "redirect:/stockMedicaments.html";
    }
    
    @GetMapping("/goAddStockMedicament.html")
    public String goToAddStockMedicament(@RequestParam("id") Long id, Model model) {
        if (id != -1) {
            model.addAttribute("medicamentStocks", medicamentStockService.getById(id));
        }
        return "editStockMedicament";
    }

    @RequestMapping(value = "/stockMedicamentAdd.html", method = {RequestMethod.GET, RequestMethod.POST})
    public String edit(@ModelAttribute MedicamentStock medicamentStock, Model model) throws UnsupportedEncodingException{
        ArrayList<String> errors = medicamentStockService.check(medicamentStock);
        
        for(String list: errors) {
            System.out.println(list);
        }
        if (errors.size() != 0)
        {
            model.addAttribute("errors", errors);
            model.addAttribute("medicamentStocks", medicamentStock);
            return "editStockMedicament";
        } else 
        {
            try {
            medicamentStockService.add(medicamentStock);
            } catch (Exception e) {
                errors.add("Дата введена не верно");
                model.addAttribute("errors", errors);
                model.addAttribute("medicamentStocks", medicamentStock);
                return "editStockMedicament";
            }
        }
        return "redirect:/stockMedicaments.html";
    }
}

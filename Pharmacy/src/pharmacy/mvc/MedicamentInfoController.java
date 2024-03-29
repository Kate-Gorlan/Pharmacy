package pharmacy.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pharmacy.entity.Medicament;
import pharmacy.service.MedicamentService;
import pharmacy.service.MedicamentStockService;

@Controller
public class MedicamentInfoController {

    @Autowired
    private MedicamentService ms;

    @Autowired
    private MedicamentStockService mss;

    @GetMapping("/medicamentinfo.html")
    public String getMedInfoById(@RequestParam("id") Long id, Model model) {

        Medicament med = ms.getById(id);
        model.addAttribute("medicament", med);

        int quantity = mss.getQuantityMedInStock(id);
        model.addAttribute("quantity", quantity);

        return "medicamentinfo";
    }

}

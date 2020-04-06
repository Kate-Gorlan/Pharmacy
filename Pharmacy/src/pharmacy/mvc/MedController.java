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

import pharmacy.common.TopMedicament;
import pharmacy.entity.Medicament;
import pharmacy.service.MedicamentService;

@Controller
public class MedController {

    @Autowired
    private MedicamentService medicamentService;

    @GetMapping("/medicaments.html")
    public String storekeeper(Model model, @RequestParam("typeTopMed") String typeMed,
            @RequestParam("view") String view) {

        if ("all".equals(view)) {
            List<Medicament> medAll = medicamentService.getAll().stream().collect(toList());
            model.addAttribute("med", medAll);
            model.addAttribute("view", view);
        } else if ("top".equals(view)) {
            List<TopMedicament> medTop = medicamentService.getTopMedicament().stream().collect(toList());
            model.addAttribute("med", medTop);
            model.addAttribute("view", view);
        } else if (!typeMed.equals("not")) {
            List<TopMedicament> top = medicamentService.getTopMedicamentType(typeMed).stream()
                    .collect(toList());
            model.addAttribute("med", top);
            model.addAttribute("typeTopMed", typeMed);
            model.addAttribute("view", "top");
        }

        return "medicaments";
    }

    @RequestMapping(value = "/typeTopMed.html", method = { RequestMethod.GET, RequestMethod.POST })
    public String typeMed(String typeTopMed, Model model) throws UnsupportedEncodingException {
        return "redirect:/medicaments.html?view=top&typeTopMed=" + typeTopMed;
    }

    @GetMapping("/deleteMedicament.html")
    public String delete(@RequestParam("id") Long id) {
        if (id != null) {
            medicamentService.deleteById(id);
        }
        return "redirect:/medicaments.html?view=all&typeTopMed=not";
    }
    
    @GetMapping("/goAddMedicament.html")
    public String goToAddMedicament(@RequestParam("id") Long id, Model model) {
        if (id != -1) {
            model.addAttribute("medicaments", medicamentService.getById(id));
        }
        return "editMedicament";
    }

    @RequestMapping(value = "/medicamentAdd.html", method = {RequestMethod.GET, RequestMethod.POST})
    public String edit(@ModelAttribute Medicament medicament, Model model) throws UnsupportedEncodingException{
        ArrayList<String> errors = new ArrayList<String>();
        medicamentService.decoding(medicament);
            try {
            medicamentService.add(medicament);
            } catch (Exception e) {
                if (e.getMessage().indexOf("ModeOfA") != -1)
                {
                errors.add("Недопустимый способ применения. Допустимые варианты: Наружное, Внутреннее, Наружное и внутренее");
                }
                else
                {
                errors.add(e.getMessage());
                }
                model.addAttribute("errors", errors);
                model.addAttribute("medicaments", medicament);
                return "editMedicament";
            }
        
        return "redirect:/medicaments.html?view=all&typeTopMed=not";
    }
}
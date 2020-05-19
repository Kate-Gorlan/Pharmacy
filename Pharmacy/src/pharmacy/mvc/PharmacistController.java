package pharmacy.mvc;

import static java.util.stream.Collectors.toList;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pharmacy.common.MedInfoAvailability;
import pharmacy.entity.Medicament;
import pharmacy.service.MedicamentService;

@Controller
public class PharmacistController {

    @Autowired
    private MedicamentService medicamentService;

    @PreAuthorize("hasRole('ROLE_PHARMACIST')")
    @GetMapping("/pharmacist.html")
    public String pharmacist(Model model, @RequestParam("idMed") Long idMed) {
        if (idMed > 0) {
            MedInfoAvailability medInfo = medicamentService.getMedInfoAvailability(idMed);
            model.addAttribute("medInfo", medInfo);
        }
        List<Medicament> medAll = medicamentService.getAll().stream().collect(toList());
        model.addAttribute("meds", medAll);
        return "pharmacist";
    }

    @PreAuthorize("hasRole('ROLE_PHARMACIST')")
    @RequestMapping(value = "/pharmacistInfo.html", method = { RequestMethod.GET, RequestMethod.POST })
    public String pharmacistInfo(Long idMed, Model model) throws UnsupportedEncodingException {
        return "redirect:/pharmacist.html?idMed=" + idMed;
    }

}

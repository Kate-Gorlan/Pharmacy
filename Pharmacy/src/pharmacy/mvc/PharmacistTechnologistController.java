package pharmacy.mvc;

import static java.util.stream.Collectors.toList;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pharmacy.common.PendingOrderEmployee;
import pharmacy.entity.PendingOrder;
import pharmacy.service.MedicamentService;
import pharmacy.service.PendingOrderService;
import pharmacy.service.RecipeMedicamentService;

@Controller
public class PharmacistTechnologistController {

    @Autowired
    private PendingOrderService pendingOrderService;

    @Autowired
    private MedicamentService medicamentService;

    @Autowired
    private RecipeMedicamentService recipeMedicamentService;

    @PreAuthorize("hasRole('ROLE_PHARMACIST')")
    @GetMapping("/pharmacistTechnologist.html")
    public String pharmacistT(Model model) {
        // ---------
        long id = 4;
        // ---------

        List<PendingOrderEmployee> medsForManufacture = pendingOrderService.findByEmployee(id).stream()
                .collect(toList());
        model.addAttribute("medsForManufacture", medsForManufacture);

        return "pharmacistTechnologist";
    }

    @PreAuthorize("hasRole('ROLE_PHARMACIST')")
    @GetMapping("/doneMed.html")
    public String goToAddMed(@RequestParam("id") Long id, @RequestParam("recipe") Long recipe,
            @RequestParam("name") String name, Model model) {
        PendingOrder po = pendingOrderService.getById(id);
        po.setTakeStatus("Изготовлено");
        pendingOrderService.add(po);
        Long med = medicamentService.findByName(name).getId();
        BigDecimal price = recipeMedicamentService.getPrice(name);

        model.addAttribute("medicamentId", med);
        model.addAttribute("price", price);

        return "addSMForTechnologist";
    }
}

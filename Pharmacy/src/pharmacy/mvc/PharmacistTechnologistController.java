package pharmacy.mvc;

import static java.util.stream.Collectors.toList;

import java.math.BigDecimal;
import org.springframework.security.core.Authentication;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pharmacy.common.PendingOrderEmployee;
import pharmacy.entity.Employee;
import pharmacy.entity.PendingOrder;
import pharmacy.entity.User;
import pharmacy.service.EmployeeService;
import pharmacy.service.MedicamentService;
import pharmacy.service.PendingOrderService;
import pharmacy.service.RecipeMedicamentService;
import pharmacy.service.UserService;

@Controller
public class PharmacistTechnologistController {

    @Autowired
    private PendingOrderService pendingOrderService;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private MedicamentService medicamentService;

    @Autowired
    private RecipeMedicamentService recipeMedicamentService;

    @PreAuthorize("hasRole('ROLE_TEHNOLOGIST')")
    @GetMapping("/pharmacistTechnologist.html")
    public String pharmacistT(Model model, Authentication auth) {
        String userLogin = auth.getName(); 
        User user = userService.getUserByLogin(userLogin);
        Employee empl = employeeService.getByUser(user.getId());
        long id = empl.getId();

        List<PendingOrderEmployee> medsForManufacture = pendingOrderService.findByEmployee(id).stream()
                .collect(toList());
        model.addAttribute("medsForManufacture", medsForManufacture);

        return "pharmacistTechnologist";
    }

    @PreAuthorize("hasRole('ROLE_TEHNOLOGIST')")
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

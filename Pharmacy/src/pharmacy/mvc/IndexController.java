package pharmacy.mvc;

import static java.util.stream.Collectors.toList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pharmacy.common.ListMedicamentType;
import pharmacy.common.TopOverdueMed;
import pharmacy.entity.Medicament;
import pharmacy.entity.Position;
import pharmacy.service.MedicamentService;
import pharmacy.service.PositionService;

@Controller
public class IndexController {

    @Autowired
    private MedicamentService medSer;
    
    @Autowired
    private PositionService positionService;

    @GetMapping("/index.html")
    public String index(Model model, Authentication authentication) {
        List<ListMedicamentType> listMedType = medSer.getTypeMed().stream().collect(toList());
        List<TopOverdueMed> listOverdueMed = medSer.getOverdueMed().stream().collect(toList());
        model.addAttribute("medTypes", listMedType);
        model.addAttribute("topMed", listOverdueMed);
        if (authentication != null) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            System.out.println(userDetails.getUsername());
            System.out.println("User has authorities: " + userDetails.getAuthorities());
        }
        return "index";
    }

    @GetMapping("/category.html")
    public String getMedInfoById(@RequestParam("category") String category, Model model) {
        List<Medicament> med = medSer.findByType(category);
        model.addAttribute("medicaments", med);
        return "category";
    }

    @PreAuthorize("hasRole('ROLE_PHARMACIST')")
    @GetMapping("/indexEmp.html")
    public String indexEmp(Model model) {
        List<Position> listPositions = positionService.getPositions().stream().collect(toList());
        model.addAttribute("positions", listPositions);
        return "indexEmp";
    }
}

package pharmacy.mvc;

import static java.util.stream.Collectors.toList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pharmacy.common.ListMedicamentType;
import pharmacy.common.TopOverdueMed;
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
    public String index(Model model) {
        List<ListMedicamentType> listMedType = medSer.getTypeMed().stream().collect(toList());
        List<TopOverdueMed> listOverdueMed = medSer.getOverdueMed().stream().collect(toList());
        model.addAttribute("medTypes", listMedType);
        model.addAttribute("topMed", listOverdueMed);
        return "index";
    }
    
    @GetMapping("/indexEmp.html")
    public String indexEmp(Model model) {
        List<Position> listPositions = positionService.getPositions().stream().collect(toList());
        model.addAttribute("positions", listPositions);
        return "indexEmp";
    }
}
package pharmacy.mvc;

import static java.util.stream.Collectors.toList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pharmacy.common.ListMedicamentType;
import pharmacy.service.MedicamentService;

@Controller
public class IndexController {
    
    @Autowired
    private MedicamentService medSer;

    @GetMapping("/index.html")
    public String index(Model model) {
        List<ListMedicamentType> listMedType = medSer.getTypeMed().stream().collect(toList());
        model.addAttribute("medTypes", listMedType);
        return "index";
    }
}
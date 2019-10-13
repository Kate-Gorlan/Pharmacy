package pharmacy.mvc;

import static java.util.stream.Collectors.toList;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pharmacy.entity.Position;
import pharmacy.service.PositionService;

@Controller
public class IndexController {
    
    @Autowired
    private PositionService positionService;

    @GetMapping("/index.html")
    public String index(Model model) {
        List<Position> listChoose = positionService.getPositions().stream().collect(toList());
        model.addAttribute("positions", listChoose);
        return "index";
    }
}
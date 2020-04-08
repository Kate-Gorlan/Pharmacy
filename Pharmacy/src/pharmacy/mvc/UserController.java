package pharmacy.mvc;

import static java.util.stream.Collectors.toList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pharmacy.entity.User;
import pharmacy.service.UserService;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users.html")
    public String users(Model model) {
        List<User> listChoose = userService.getUsers().stream().collect(toList());
        model.addAttribute("users", listChoose);
        return "users";
    }
}

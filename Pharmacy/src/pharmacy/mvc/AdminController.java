package pharmacy.mvc;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pharmacy.service.PositionService;

@Controller
public class AdminController {
    
    @Autowired
    private PositionService positionService;

    @GetMapping("/admin.html")
    public String storekeeper(Model model, 
            @RequestParam("login") String login, 
            @RequestParam("pass") String pass, 
            @RequestParam("table") String table, 
            @RequestParam("func") String func, 
            @RequestParam("doBD") String doBD) throws SQLException {
        
        String message = "";
        if (doBD.equals("add")) {
            try {
            positionService.addlogin(login, pass);
            message = "Добавление прошло успешно";
            } catch (Exception e) {
                message = "Пользователь не был добавлен. Ошибка: " + e;
            }
        }
        if (doBD.equals("delete")) {
            try {
            positionService.deletelogin(login);
            message = "Удаление прошло успешно";
            } catch (Exception e) {
                message = "Пользователь не был удален. Ошибка: " + e;
            }
        }
        if (doBD.equals("grant")) {
            try {
            positionService.grantlogin(func, table, login);
            message = "Добавление прошло успешно";
            } catch (Exception e) {
                message = "Права не были добавлены. Ошибка: " + e;
            }
        }
        if (doBD.equals("revoke")) {
            try {
            positionService.revokelogin(func, table, login);
            message = "Удаление прошло успешно";
            } catch (Exception e) {
                message = "Права не были удалены. Ошибка: " + e;
            }
        }
        model.addAttribute("message", message);
        return "admin";  
    }
    
    @RequestMapping(value = "/addlogin.html", method = {RequestMethod.GET, RequestMethod.POST})
    public String addlogin(String login, String pass, Model model) throws UnsupportedEncodingException{
        return "redirect:/admin.html?doBD=add&func=not&table=not&login="+login+"&pass="+pass;
    }
    
    @RequestMapping(value = "/deletelogin.html", method = {RequestMethod.GET, RequestMethod.POST})
    public String deletelogin(String login, Model model) throws UnsupportedEncodingException{
        return "redirect:/admin.html?doBD=delete&func=not&table=not&login="+login+"&pass=not";
    }
    @RequestMapping(value = "/grantlogin.html", method = {RequestMethod.GET, RequestMethod.POST})
    public String grantlogin(String func, String table, String login, Model model) throws UnsupportedEncodingException{
        return "redirect:/admin.html?doBD=grant&func="+func+"&table="+table+"&login="+login+"&pass=not";
    }
    
    @RequestMapping(value = "/revokelogin.html", method = {RequestMethod.GET, RequestMethod.POST})
    public String revokelogin(String func, String table, String login, Model model) throws UnsupportedEncodingException{
        return "redirect:/admin.html?doBD=revoke&func="+func+"&table="+table+"&login="+login+"&pass=not";
    }

}
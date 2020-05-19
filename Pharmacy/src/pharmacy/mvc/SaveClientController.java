package pharmacy.mvc;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pharmacy.entity.Client;
import pharmacy.service.ClientService;

@Controller
public class SaveClientController {

    @Autowired
    private ClientService clientService;

    @PreAuthorize("hasRole('ROLE_PHARMACIST')")
    @GetMapping("/goAddClient.html")
    public String goToAddClient(@RequestParam("id") Long id, Model model) {
        if (id != -1) {
            model.addAttribute("clients", clientService.getClientById(id));
        }
        return "editClient";
    }

    @PreAuthorize("hasRole('ROLE_PHARMACIST')")
    @RequestMapping(value = "/clientAdd.html", method = {RequestMethod.GET, RequestMethod.POST})
    public String edit(@ModelAttribute Client client, Model model) throws UnsupportedEncodingException{
        clientService.decoding(client);
        ArrayList<String> errors = clientService.check(client);
        
        for(String list: errors) {
            System.out.println(list);
        }
        if (errors.size() != 0)
        {
            model.addAttribute("errors", errors);
            model.addAttribute("clients", client);
            return "editClient";
        }
        clientService.add(client);
        return "redirect:/clients.html";
    }

    @PreAuthorize("hasRole('ROLE_PHARMACIST')")
    @GetMapping("/deleteClient.html")
    public String delete(@RequestParam("id") Long id) {
        if (id != null) {
            clientService.deleteById(id);
        }
        return "redirect:/clients.html";
    }
}

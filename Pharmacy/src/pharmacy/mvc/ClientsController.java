package pharmacy.mvc;

import static java.util.stream.Collectors.toList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pharmacy.entity.Client;
import pharmacy.common.ClientNotTakenOrder;
import pharmacy.service.ClientService;

@Controller
public class ClientsController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/clients.html")
    public String clients(Model model) {
        List<Client> listChoose = clientService.getClients().stream().collect(toList());
        model.addAttribute("clients", listChoose);
        List<ClientNotTakenOrder> test = clientService.getNotTakeOrderClient().stream().collect(toList());
        model.addAttribute("test", test);
        return "clients";
    }

}

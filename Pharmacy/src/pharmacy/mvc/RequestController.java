package pharmacy.mvc;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import pharmacy.entity.Client;
import pharmacy.entity.Medicament;
import pharmacy.entity.Request;
import pharmacy.entity.User;
import pharmacy.service.ClientService;
import pharmacy.service.MedicamentService;
import pharmacy.service.RequestService;
import pharmacy.service.UserService;

@Controller
public class RequestController {

    @Autowired
    private ClientService cs;

    @Autowired
    private RequestService rs;

    @Autowired
    private UserService us;

    @Autowired
    private MedicamentService ms;

    // @GetMapping("/request")
    // public String file(Authentication auth, Model model) {
    // return "index";
    // }

    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(value = "/request.html", method = { RequestMethod.POST })
    public String req(@RequestParam(value = "id") Long id, @RequestParam(value = "q", required = false) Integer quantity,
            @RequestParam(value = "img", required = false) MultipartFile img, Authentication authentication) {

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        User user = us.getUserByLogin(userDetails.getUsername());
        Client client = cs.getClientByUserId(user.getId());
        Medicament med = ms.getById(id);

        Request req = new Request();
        if (img != null) {
            try {
                req.setImg(img.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        req.setClient(client);
        req.setMedicament(med);
        if (quantity == null) {
            req.setQuantity(1);
        } else {
            req.setQuantity(quantity);
        }
        req.setStatus("В обработке");
        rs.add(req);

        return "redirect:/medicamentinfo.html?id=" + id;
    }

    public String savePicReq(Long id) throws Exception {

        String path = this.getClass().getClassLoader().getResource("").getPath();
        String fullPath = URLDecoder.decode(path, "UTF-8");
        String pathArr[] = fullPath.split("/WEB-INF/classes/");
        fullPath = pathArr[0];

        ByteArrayInputStream bis = new ByteArrayInputStream(rs.getById(id).getImg());
        BufferedImage bImage2 = ImageIO.read(bis);
        ImageIO.write(bImage2, "jpg", new File(fullPath + "\\resources\\cache\\img" + rs.getById(id).getId() + ".jpg"));

       

        return "resources\\cache\\img" + rs.getById(id).getId() + ".jpg";
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/dltreq.html")
    public String deleteRequest(@RequestParam("id") Long id, Authentication auth) throws Exception {

        rs.deleteById(id);

        return "redirect:/user.html?l=" + auth.getName();
    }

    @PreAuthorize("hasRole('ROLE_PHARMACIST')")
    @GetMapping("/requestlist.html")
    public String requestList(Model model) {
        model.addAttribute("listReq", rs.findAllByStatus("В обработке"));
        return "requestlist";
    }

    @PreAuthorize("hasRole('ROLE_PHARMACIST')")
    @GetMapping("/reqinfo.html")
    public String reqInfo(@RequestParam("id") Long id, Model model) {
        model.addAttribute("req", rs.getById(id));
        try {
            model.addAttribute("pic", savePicReq(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "reqinfo";
    }

    @PreAuthorize("hasRole('ROLE_PHARMACIST')")
    @GetMapping("/approve.html")
    public String reqApprove(@RequestParam("id") Long id) {
        Request req = rs.getById(id);
        req.setStatus("Одобрен");
        rs.add(req);
        return "redirect:/requestlist.html";
    }  

    @PreAuthorize("hasRole('ROLE_PHARMACIST')")
    @GetMapping("/decline.html")
    public String reqDecline(@RequestParam("id") Long id) {
        Request req = rs.getById(id);
        req.setStatus("Отклонен");
        rs.add(req);
        return "redirect:/requestlist.html";
    }
}

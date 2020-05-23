package pharmacy.mvc;

import static java.util.stream.Collectors.toList;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pharmacy.entity.Doctor;
import pharmacy.service.DoctorService;

@Controller
public class DoctorsController {

    @Autowired
    private DoctorService doctorService;

    @PreAuthorize("hasRole('ROLE_PHARMACIST')")
    @GetMapping("/doctors.html")
    public String doctors(Model model) {
        List<Doctor> listChoose = doctorService.getAll().stream().collect(toList());
        model.addAttribute("doctors", listChoose);
        return "doctors";
    }

    @PreAuthorize("hasRole('ROLE_PHARMACIST')")
    @GetMapping("/goAddDoctor.html")
    public String goToAddDoctor(@RequestParam("id") Long id, Model model) {
        if (id != -1) {
            model.addAttribute("doctors", doctorService.getById(id));
        }
        return "editDoctor";
    }

    @PreAuthorize("hasRole('ROLE_PHARMACIST')")
    @RequestMapping(value = "/doctorAdd.html", method = {RequestMethod.GET, RequestMethod.POST})
    public String edit(@ModelAttribute Doctor doctor, Model model) throws UnsupportedEncodingException{
        doctorService.decoding(doctor);
        ArrayList<String> errors = doctorService.check(doctor);
        
        for(String list: errors) {
            System.out.println(list);
        }
        if (errors.size() != 0)
        {
            model.addAttribute("errors", errors);
            model.addAttribute("doctors", doctor);
            return "editClient";
        }
        doctorService.add(doctor);
        return "redirect:/doctors.html";
    }

    @PreAuthorize("hasRole('ROLE_PHARMACIST')")
    @GetMapping("/deleteDoctor.html")
    public String delete(@RequestParam("id") Long id) {
        if (id != null) {
            doctorService.deleteById(id);
        }
        return "redirect:/doctors.html";
    }
}

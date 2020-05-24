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

import pharmacy.entity.Client;
import pharmacy.entity.Doctor;
import pharmacy.entity.Medicament;
import pharmacy.entity.Prescription;
import pharmacy.service.ClientService;
import pharmacy.service.DoctorService;
import pharmacy.service.MedicamentService;
import pharmacy.service.PrescriptionService;

@Controller
public class PrescriptionController {

    @Autowired
    private PrescriptionService prescriptionService;
    
    @Autowired
    private MedicamentService medicamentService;
    
    @Autowired
    private ClientService clientService;
    
    @Autowired
    private DoctorService doctorService;

    @PreAuthorize("hasRole('ROLE_PHARMACIST')")
    @GetMapping("/prescriptions.html")
    public String prescriptions(Model model) {
        List<Prescription> prescriptions = prescriptionService.getAll().stream().collect(toList());
        model.addAttribute("prescriptions", prescriptions);
        List<Prescription> prescriptionsNew = prescriptionService.getNew().stream().collect(toList());
        model.addAttribute("prescriptionsNew", prescriptionsNew);
        return "prescriptions";
    }

    @PreAuthorize("hasRole('ROLE_PHARMACIST')")
    @GetMapping("/prescription.html")
    public String prescription(@RequestParam("id") Long id, @RequestParam("idPO") Long idPO, Model model) {
        model.addAttribute("prescription", prescriptionService.getById(id));
        if (idPO != -1) {
            model.addAttribute("idPO", idPO);
        }
        return "prescription";
    }

    @PreAuthorize("hasRole('ROLE_PHARMACIST')")
    @GetMapping("/deletePrescription.html")
    public String delete(@RequestParam("id") Long id) {
        if (id != null) {
            prescriptionService.deleteById(id);
        }
        return "redirect:/prescriptions.html";
    }

    @PreAuthorize("hasRole('ROLE_PHARMACIST')")
    @GetMapping("/goAddPrescription.html")
    public String goToAddPrescription(@RequestParam("id") Long id, Model model) {
        if (id != -1) {
            model.addAttribute("prescriptions", prescriptionService.getById(id));
        }

        List<Client> cls = clientService.getClients();
        List<Doctor> dcs = doctorService.getAll();
        List<Medicament> meds = medicamentService.getAll();
        model.addAttribute("cls", cls);
        model.addAttribute("dcs", dcs);
        model.addAttribute("meds", meds);
        return "editPrescription";
    }

    @PreAuthorize("hasRole('ROLE_PHARMACIST')")
    @RequestMapping(value = "/prescriptionAdd.html", method = { RequestMethod.GET, RequestMethod.POST })
    public String edit(@ModelAttribute Prescription prescription, Model model) throws UnsupportedEncodingException {
        ArrayList<String> errors = prescriptionService.check(prescription);

        List<Client> cls = clientService.getClients();
        List<Doctor> dcs = doctorService.getAll();
        List<Medicament> meds = medicamentService.getAll();

        for (String list : errors) {
            System.out.println(list);
        }
        if (errors.size() != 0) {
            model.addAttribute("errors", errors);
            model.addAttribute("prescriptions", prescription);
            model.addAttribute("cls", cls);
            model.addAttribute("dcs", dcs);
            model.addAttribute("meds", meds);
            return "editPrescription";
        } else {
            try {
                prescriptionService.add(prescription);
            } catch (Exception e) {

                errors.add("Ошибка: " + e.getMessage());

                model.addAttribute("errors", errors);
                model.addAttribute("prescriptions", prescription);
                model.addAttribute("cls", cls);
                model.addAttribute("dcs", dcs);
                model.addAttribute("meds", meds);
                return "editPrescription";
            }
        }
        return "redirect:/prescriptions.html";
    }
}

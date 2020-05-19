package pharmacy.mvc;

import static java.util.stream.Collectors.toList;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pharmacy.mvc.formvalidation.FormClient;
import pharmacy.entity.User;
import pharmacy.service.ClientService;
import pharmacy.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private FormClient form;

    private Validator validator = new UserFormValidator();

    @InitBinder("form")
    protected void initBinding(WebDataBinder binder) {
        binder.addValidators(validator);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/users.html")
    public String users(Model model) {
        List<User> listChoose = userService.getUsers().stream().collect(toList());
        model.addAttribute("users", listChoose);
        return "users";
    }
    
    @ModelAttribute("form")
    public FormClient requestClient(@RequestParam(value = "id", required = false) final Long id) {
        form.clear();
        if (id != null) {
            form.setClient(clientService.getClientById(id));
        }
        return form;
    }

    /*
     * @RequestMapping(value = "/edit.html", method= RequestMethod.GET) public
     * String edit() { return "user"; }
     */

    @RequestMapping(value = "/registration.html", method = RequestMethod.GET)
    public String registr() {
        return "registration";
    }

    @RequestMapping(value = "/reg.html", method = RequestMethod.POST)
    public String save(@Valid @ModelAttribute("form") final FormClient form, final BindingResult result,
            final RedirectAttributes redirectAttributes) {
        // validator.validate(form, result);
        
        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("form", form);
            redirectAttributes.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "form", result);
            return "redirect:/registration.html";
        } else {
            clientService.saveCient(userService, form);
            form.clear();
            return "redirect:/index.html";
        }
    }

    private class UserFormValidator implements Validator {
        @Override
        public boolean supports(final Class<?> clazz) {
            return clazz.isInstance(form);
        }

        @Override
        public void validate(final Object target, final Errors errors) {
            FormClient form = (FormClient) target;

            if (form.getUser().getPassword().trim().isEmpty()) {
                errors.rejectValue("user.password", "error.user.empty.password");
            }

            if (form.getUser().getLogin().trim().isEmpty()) {
                errors.rejectValue("user.login", "error.user.empty.login");
            }

            if (form.getPassword().trim().isEmpty()) {
                errors.rejectValue("password", "error.user.empty.password");
            }

            if (form.getClient().getAddress().trim().isEmpty()) {
                errors.rejectValue("client.address", "error.user.empty.adress");
            }

            if (form.getClient().getAge() == null) {
                errors.rejectValue("client.age", "error.user.empty.age");
            }

            if (form.getClient().getFullName().trim().isEmpty()) {
                errors.rejectValue("client.fullName", "error.user.empty.name");
            }

            if (form.getClient().getPhone().trim().isEmpty()) {
                errors.rejectValue("client.phone", "error.user.empty.phone");
            }

            if (form.getUser().getId() == null && userService.getUserByLogin(form.getUser().getLogin()) != null) {
                errors.rejectValue("user.login", "error.user.duplicate.name", new Object[] { form.getUser().getLogin() },
                        "User exist!");
            }

            if (!form.getPassword().trim().equals(form.getUser().getPassword().trim())) {
                errors.rejectValue("user.password", "error.user.notEquals.password");
                errors.rejectValue("password", "error.user.notEquals.password");
            }
        }
    }
}

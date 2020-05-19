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

import pharmacy.common.ProductProgress;
import pharmacy.entity.Product;
import pharmacy.service.ProductService;

@Controller
public class ProdController {

    @Autowired
    private ProductService productService;

    @PreAuthorize("hasRole('ROLE_PHARMACIST')")
    @GetMapping("/products.html")
    public String storekeeper(Model model,
            @RequestParam("page") Long page,
            @RequestParam("name") String name,
            @RequestParam("prodNumByPeriod") String prodNumByPeriod,
            @RequestParam("view") String view) {

        if ("progress".equals(view)) {
            List<ProductProgress> prodProgress = productService.getProductForOrderInProduction().stream().collect(toList());
            model.addAttribute("prod", prodProgress);
            model.addAttribute("view", view);
        } else {
        List<Product> prodAll = productService.getAll().stream().collect(toList());
        model.addAttribute("prod", prodAll);
        model.addAttribute("view", view);
        }
        if (!name.equals("not")) {
            int prodNumByName = productService.getVolumeOfProductUsed(name);
            model.addAttribute("prodNumByName", prodNumByName);
        }
        if (!prodNumByPeriod.equals("not")) {
        model.addAttribute("prodNumByPeriod", prodNumByPeriod);
        }
        model.addAttribute("name", name);
        model.addAttribute("page", page);

        return "products";
    }

    @PreAuthorize("hasRole('ROLE_PHARMACIST')")
    @RequestMapping(value = "/nameProd.html", method = { RequestMethod.GET, RequestMethod.POST })
    public String typeMed(String name, Model model) throws UnsupportedEncodingException {
        return "redirect:/products.html?view=all&prodNumByPeriod=not&name=" + name+"&page=2";
    }

    @PreAuthorize("hasRole('ROLE_PHARMACIST')")
    @GetMapping("/deleteProduct.html")
    public String delete(@RequestParam("id") Long id, @RequestParam("page") Long page) {
        if (id != null) {
            productService.deleteById(id);
        }
        return "redirect:/products.html?view=all&prodNumByPeriod=not&name=not&page="+page;
    }
    
    @PreAuthorize("hasRole('ROLE_PHARMACIST')")
    @GetMapping("/goAddProduct.html")
    public String goToAddProduct(@RequestParam("id") Long id, @RequestParam("page") Long page, Model model) {
        if (id != -1) {
            model.addAttribute("products", productService.getById(id));
        }
        model.addAttribute("page", page);
        return "editProduct";
    }

    @PreAuthorize("hasRole('ROLE_PHARMACIST')")
    @RequestMapping(value = "/productAdd.html", method = {RequestMethod.GET, RequestMethod.POST})
    public String edit(@ModelAttribute Product product, @RequestParam("page") Long page, Model model) throws UnsupportedEncodingException{
        ArrayList<String> errors = new ArrayList<String>();
        productService.decoding(product);
            try {
            productService.add(product);
            } catch (Exception e) {
                errors.add(e.getMessage());
                model.addAttribute("errors", errors);
                model.addAttribute("products", product);
                model.addAttribute("page", page);
                return "editProduct";
            }
        
        return "redirect:/products.html?view=all&prodNumByPeriod=not&name=not&page="+page;
    }
    
    @PreAuthorize("hasRole('ROLE_PHARMACIST')")
    @GetMapping("/progressProd.html")
    public String goProgressProd(Model model) {
        List<Product> prods = productService.getAll();
        model.addAttribute("prods", prods);
        return "VolumeOfPUForThePeriod";
    }
    
    @PreAuthorize("hasRole('ROLE_PHARMACIST')")
    @RequestMapping(value = "/productProgress.html", method = {RequestMethod.GET, RequestMethod.POST})
    public String progressProd(String name, String fd, String sd, Model model) throws UnsupportedEncodingException{
        String name2 = new String(name.getBytes("iso-8859-1"), "utf-8");
        List<Product> prodAll = productService.getAll();
        ArrayList<String> errors = productService.errorsProdProgress(name2, fd, sd);
        if (errors.size() != 0)
        {
            model.addAttribute("prods", prodAll);
            model.addAttribute("errors", errors);
            model.addAttribute("name", name2);
            model.addAttribute("fd", fd);
            model.addAttribute("sd", sd);
            return "VolumeOfPUForThePeriod";
        }
        
        model.addAttribute("prod", prodAll);
        int prodNumByPeriod;
        try {
        prodNumByPeriod = productService.getVolumeOfPUForThePeriod(name2, fd, sd);
        } catch (Exception e) {
            errors.add("Ошибка: " + e);
            model.addAttribute("prods", prodAll);
            model.addAttribute("errors", errors);
            model.addAttribute("name", name2);
            model.addAttribute("fd", fd);
            model.addAttribute("sd", sd);
            return "VolumeOfPUForThePeriod";
        }
        
        return "redirect:/products.html?view=all&name=not&prodNumByPeriod="+prodNumByPeriod+"&page=2";
    }
}
package pharmacy.mvc;

import static java.util.stream.Collectors.toList;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pharmacy.common.MedCriticalNorm;
import pharmacy.common.ProductCriticalNorm;
import pharmacy.entity.Client;
import pharmacy.entity.Medicament;
import pharmacy.entity.Product;
import pharmacy.service.MedicamentService;
import pharmacy.service.ProductService;

@Controller
public class StorekeeperController {
    
    @Autowired
    private ProductService productService;
    
    @Autowired
    private MedicamentService medicamentService;

    @GetMapping("/storekeeper.html")
    public String storekeeper(Model model, 
            @RequestParam("typeMed") String typeMed, 
            @RequestParam("typeProd") String typeProd) {
        
        List<Product> prodOver = productService.getProdOver().stream().collect(toList());
        model.addAttribute("prodOver", prodOver);
        List<ProductCriticalNorm> criticalNormProduct = productService.getReachedCriticalNormProduct().stream().collect(toList());
        model.addAttribute("criticalNormProduct", criticalNormProduct);
        List<ProductCriticalNorm> minProductInStock = productService.getMinProductInStock().stream().collect(toList());
        model.addAttribute("minProduct", minProductInStock);
        if (!typeProd.equals("not")) {
            List<ProductCriticalNorm> minProductInStockByType = productService.getMinProductInStockByType(typeProd).stream().collect(toList());
            model.addAttribute("minProductByType", minProductInStockByType);
            model.addAttribute("typeProd", typeProd);
        }
        
        List<Medicament> medOver = medicamentService.getMedOver().stream().collect(toList());
        model.addAttribute("medOver", medOver);
        List<MedCriticalNorm> criticalNormMedicament = medicamentService.getReachedCriticalNorm().stream().collect(toList());
        model.addAttribute("criticalNormMedicament", criticalNormMedicament);
        List<MedCriticalNorm> minMedicamentInStock = medicamentService.getMinMedInStock().stream().collect(toList());
        model.addAttribute("minMedicament", minMedicamentInStock);
        if (!typeMed.equals("not")) {
            List<MedCriticalNorm> minMedicamentInStockByType = medicamentService.getMinMedInStockByType(typeMed).stream().collect(toList());
            model.addAttribute("minMedicamentByType", minMedicamentInStockByType);
            model.addAttribute("typeMed", typeMed);
        }
        
        return "storekeeper";  
    }
    
    @RequestMapping(value = "/typeMed.html", method = {RequestMethod.GET, RequestMethod.POST})
    public String typeMed(String typeMed, Model model) throws UnsupportedEncodingException{
        return "redirect:/storekeeper.html?typeProd=not&typeMed="+typeMed;
    }
    
    @RequestMapping(value = "/typeProd.html", method = {RequestMethod.GET, RequestMethod.POST})
    public String typeProd(String typeProd, Model model) throws UnsupportedEncodingException{
        return "redirect:/storekeeper.html?typeMed=not&typeProd="+typeProd;
    }

}
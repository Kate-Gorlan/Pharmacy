package pharmacy.mvc;

import static java.util.stream.Collectors.toList;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pharmacy.common.MedCriticalNorm;
import pharmacy.common.ProductCriticalNorm;
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
        if (typeProd != null) {
            List<ProductCriticalNorm> minProductInStockByType = productService.getMinProductInStockByType(typeProd).stream().collect(toList());
            model.addAttribute("minProductByType", minProductInStockByType);
        }
        
        List<Medicament> medOver = medicamentService.getMedOver().stream().collect(toList());
        model.addAttribute("medOver", medOver);
        List<MedCriticalNorm> criticalNormMedicament = medicamentService.getReachedCriticalNorm().stream().collect(toList());
        model.addAttribute("criticalNormMedicament", criticalNormMedicament);
        List<MedCriticalNorm> minMedicamentInStock = medicamentService.getMinMedInStock().stream().collect(toList());
        model.addAttribute("minMedicament", minMedicamentInStock);
        if (typeMed != null) {
            List<MedCriticalNorm> minMedicamentInStockByType = medicamentService.getMinMedInStockByType(typeMed).stream().collect(toList());
            model.addAttribute("minMedicamentByType", minMedicamentInStockByType);
        }
        
        return "storekeeper";
    }
    
}
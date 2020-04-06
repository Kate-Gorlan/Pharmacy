package pharmacy.mvc;

import static java.util.stream.Collectors.toList;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.SQLErrorCodes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pharmacy.entity.ProductStock;
import pharmacy.service.ProductStockService;


@Controller
public class StockProdController {

    @Autowired
    private ProductStockService productStockService;

    @GetMapping("/stockProducts.html")
    public String stockProducts(Model model) {
        List<ProductStock> listChoose = productStockService.getAll().stream().collect(toList());
        model.addAttribute("prodStock", listChoose);
        return "stockProducts";
    }

    @GetMapping("/deleteStockProduct.html")
    public String delete(@RequestParam("id") Long id) {
        if (id != null) {
            productStockService.deleteById(id);
        }
        return "redirect:/stockProducts.html";
    }
    
    @GetMapping("/goAddStockProduct.html")
    public String goToAddStockProduct(@RequestParam("id") Long id, Model model) {
        if (id != -1) {
            model.addAttribute("productStocks", productStockService.getById(id));
        }
        return "editStockProduct";
    }

    @RequestMapping(value = "/stockProductAdd.html", method = {RequestMethod.GET, RequestMethod.POST})
    public String edit(@ModelAttribute ProductStock productStock, Model model) throws UnsupportedEncodingException{
        ArrayList<String> errors = productStockService.check(productStock);
        
        for(String list: errors) {
            System.out.println(list);
        }
        if (errors.size() != 0)
        {
            model.addAttribute("errors", errors);
            model.addAttribute("productStocks", productStock);
            return "editStockProduct";
        } else 
        {
            try {
            productStockService.add(productStock);
            } catch (Exception e) {

                errors.add("Ошибка: " + e.getMessage());

                model.addAttribute("errors", errors);
                model.addAttribute("productStocks", productStock);
                return "editStockProduct";
            }
        }
        return "redirect:/stockProducts.html";
    }
}

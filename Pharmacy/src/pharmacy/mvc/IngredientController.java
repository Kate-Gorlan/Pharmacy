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

import pharmacy.entity.Ingredient;
import pharmacy.entity.Medicament;
import pharmacy.entity.Product;
import pharmacy.entity.RecipeMedicament;
import pharmacy.service.IngredientService;
import pharmacy.service.MedicamentService;
import pharmacy.service.ProductService;
import pharmacy.service.RecipeMedicamentService;

@Controller
public class IngredientController {

    @Autowired
    private IngredientService ingredientService;
    
    @Autowired
    private ProductService productService;

    @PreAuthorize("hasRole('ROLE_TEHNOLOGIST')")
    @GetMapping("/deleteIngredient.html")
    public String delete(@RequestParam("id") Long id, @RequestParam("recipeId") Long recipeId) {
        if (id != null) {
            ingredientService.deleteById(id);
        }
        return "redirect:/recipe.html?id="+recipeId;
    }
    
    @PreAuthorize("hasRole('ROLE_TEHNOLOGIST')")
    @GetMapping("/goAddIngredient.html")
    public String goToAddRecipe(@RequestParam("id") Long id, Model model, @RequestParam("recipeId") Long recipeId) {
        if (id != -1) {
            model.addAttribute("ingrs", ingredientService.getById(id));
        }
        
        List<Product> prods = productService.getAll();
        model.addAttribute("prods", prods);
        model.addAttribute("recipeId", recipeId);
        return "editIngredient";
    }

    @PreAuthorize("hasRole('ROLE_TEHNOLOGIST')")
    @RequestMapping(value = "/ingredientAdd.html", method = {RequestMethod.GET, RequestMethod.POST})
    public String edit(@ModelAttribute Ingredient ingr, Model model, @RequestParam("recipeId") Long recipeId) throws UnsupportedEncodingException{
        ArrayList<String> errors = ingredientService.check(ingr);
        List<Product> prods = productService.getAll();
        
        for(String list: errors) {
            System.out.println(list);
        }
        if (errors.size() != 0)
        {
            model.addAttribute("errors", errors);
            model.addAttribute("ingrs", ingr);
            model.addAttribute("prods", prods);
            model.addAttribute("recipeId", recipeId);
            return "editIngredient";
        } else 
        {
            try {
                ingredientService.add(ingr);
            } catch (Exception e) {
                errors.add("Ошибка: " + e.getMessage());
               
                model.addAttribute("errors", errors);
                model.addAttribute("ingrs", ingr);
                model.addAttribute("prods", prods);
                model.addAttribute("recipeId", recipeId);
                return "editIngredient";
            }
        }
        return "redirect:/recipe.html?id="+recipeId;
    }
}

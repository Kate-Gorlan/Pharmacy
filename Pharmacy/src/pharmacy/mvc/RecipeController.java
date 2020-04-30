package pharmacy.mvc;

import static java.util.stream.Collectors.toList;

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

import pharmacy.entity.Medicament;
import pharmacy.entity.RecipeMedicament;
import pharmacy.service.MedicamentService;
import pharmacy.service.RecipeMedicamentService;

@Controller
public class RecipeController {

    @Autowired
    private RecipeMedicamentService recipeMedicamentService;
    
    @Autowired
    private MedicamentService medicamentService;
    
   // @Autowired
   // private ProductService productService;
    
    @GetMapping("/recipes.html")
    public String recipesMed(Model model) {
        List<RecipeMedicament> allRecipes = recipeMedicamentService.getAll().stream().collect(toList());
        model.addAttribute("recipes", allRecipes);
        return "recipes";
    }
    
    @GetMapping("/recipe.html")
    public String recipe(@RequestParam("id") Long id, Model model) {
        model.addAttribute("recipe", recipeMedicamentService.getById(id));
        return "recipe";
    }
    
    /*@GetMapping("/rec.html")
    public String rec(@RequestParam("name") String name, Model model) {
         RecipeMedicament rec = recipeMedicamentService.getByName(name);
         Long id = rec.getId();
        return "redirect:/recipe.html?id="+id;
    }*/
    
    @GetMapping("/deleteRecipe.html")
    public String delete(@RequestParam("id") Long id) {
        if (id != null) {
            recipeMedicamentService.deleteById(id);
        }
        return "redirect:/recipes.html";
    }
    
    @GetMapping("/goAddRecipe.html")
    public String goToAddRecipe(@RequestParam("id") Long id, Model model) {
        if (id != -1) {
            model.addAttribute("recipes", recipeMedicamentService.getById(id));
        }
        
        //List<Product> prods = productService.getAll();
        List<Medicament> meds = medicamentService.findByManufacturability("1");
        //model.addAttribute("prods", prods);
        model.addAttribute("meds", meds);
        return "editRecipe";
    }

    @RequestMapping(value = "/recipeAdd.html", method = {RequestMethod.GET, RequestMethod.POST})
    public String edit(@ModelAttribute RecipeMedicament recipe, Model model) throws UnsupportedEncodingException{
        ArrayList<String> errors = recipeMedicamentService.check(recipe);
        //List<Product> prods = productService.getAll();
        List<Medicament> meds = medicamentService.findByManufacturability("1");
        
        for(String list: errors) {
            System.out.println(list);
        }
        if (errors.size() != 0)
        {
            model.addAttribute("errors", errors);
            model.addAttribute("recipes", recipe);
            //model.addAttribute("prods", prods);
            model.addAttribute("meds", meds);
            return "editRecipe";
        } else 
        {
            try {
                recipeMedicamentService.add(recipe);
            } catch (Exception e) {
                if (e.getMessage().indexOf("U_Med") != -1)
                {
                errors.add("Рецепт для данного медикамента уже существует");
                }
                else
                {
                errors.add("Ошибка: " + e.getMessage());
                }
                model.addAttribute("errors", errors);
                model.addAttribute("recipes", recipe);
                //model.addAttribute("prods", prods);
                model.addAttribute("meds", meds);
                return "editRecipe";
            }
        }
        //String name = recipe.getMedicament().getName();
        return "redirect:/recipes.html";
        //return "redirect:/rec.html?name="+name;
    }
}

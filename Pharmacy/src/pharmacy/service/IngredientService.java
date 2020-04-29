package pharmacy.service;

import java.util.Collections;
import java.util.List;

import pharmacy.dao.IngredientDao;
import pharmacy.entity.Ingredient;

public class IngredientService {

    private IngredientDao ingredientDao;

    public IngredientDao getIngredientDao() {
        return ingredientDao;
    }

    public void setIngredientDao(IngredientDao ingredientDao) {
        this.ingredientDao = ingredientDao;
    }
    
    public void add(Ingredient obj) {
        if (obj.getId() == null) {
            ingredientDao.create(obj);
        } else {
            ingredientDao.update(obj);
        }
    }
    
/*    public void save(Ingredient obj, String name) {
        RecipeMedicament rec = recipeMedicamentDao.findByMedName(recipe.getMedicament().getName());
        for (Ingredient ing : recipe.getIngredients()) {
            //if (ing.getProduct() != null && ing.getMoney() != null && ing.getQuantity() != null
             //       && ing.getTimeForPreparing() != null) {
                Ingredient ingred = ing;
                ingred.setRecipeMedicament(rec);
                ingredientDao.add(ingred);
            //}
        }
    }*/
    
    public Ingredient getById(Long id) {
        return ingredientDao.read(id);
    }
    
    public List<Ingredient> getAll(){
        List<Ingredient> reverse = ingredientDao.findAll();
        Collections.reverse(reverse);
        return reverse;
    }
    
    public void deleteById(Long id) {
        ingredientDao.delete(id);
    }

}

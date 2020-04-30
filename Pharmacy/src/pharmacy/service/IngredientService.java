package pharmacy.service;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import pharmacy.dao.IngredientDao;
import pharmacy.dao.ProductDao;
import pharmacy.entity.Ingredient;
import pharmacy.entity.Product;

public class IngredientService {

    private IngredientDao ingredientDao;
    
    private ProductDao productDao;

    public IngredientDao getIngredientDao() {
        return ingredientDao;
    }

    public void setIngredientDao(IngredientDao ingredientDao) {
        this.ingredientDao = ingredientDao;
    }
    
    public ProductDao getProductDao() {
        return productDao;
    }

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
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
    public ArrayList<String> check(Ingredient ingr) throws UnsupportedEncodingException {
        ArrayList<String> errors = new ArrayList<String>();
        Long id = ingr.getProduct().getId();
        Product prod = productDao.read(id);
        if (prod == null) {
            errors.add("Запись о продукте не найдена");
        }
        if (ingr.getQuantity() <= 0) {
            errors.add("Количество продукта не может быть нулем или меньше нуля");
        }
        if (ingr.getTimeForPreparing() <= 0) {
            errors.add("Время изготовления не может быть нулем или меньше нуля");
        }
        if (ingr.getMoney().compareTo(new BigDecimal(0)) == -1) {
            errors.add("Цена изготовления не может быть меньше нуля");
        }

        return errors;
    }
    
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

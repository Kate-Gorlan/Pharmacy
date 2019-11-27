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

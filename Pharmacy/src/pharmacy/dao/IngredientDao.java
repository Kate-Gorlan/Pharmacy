package pharmacy.dao;

import java.util.List;

import pharmacy.entity.Ingredient;

public interface IngredientDao extends CrudDao<Long, Ingredient>{

    Ingredient findIngredient(Long id);
    
    void add(Ingredient obj);
    
    List<Ingredient> findAll();

}

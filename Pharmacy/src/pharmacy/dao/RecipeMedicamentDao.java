package pharmacy.dao;

import java.util.List;

import pharmacy.entity.RecipeMedicament;

public interface RecipeMedicamentDao extends CrudDao<Long, RecipeMedicament>{

    RecipeMedicament findRecipeMedicament(Long id);
    
    List<RecipeMedicament> findAll();

}

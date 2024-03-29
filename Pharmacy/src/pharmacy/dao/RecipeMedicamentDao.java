package pharmacy.dao;

import java.math.BigDecimal;
import java.util.List;

import pharmacy.entity.RecipeMedicament;

public interface RecipeMedicamentDao extends CrudDao<Long, RecipeMedicament>{

    RecipeMedicament findRecipeMedicament(Long id);
    
    RecipeMedicament findByMedId(Long id);
    
    List<RecipeMedicament> findAll();
    
    BigDecimal getPrice(String name);

}

package pharmacy.dao;

import java.util.List;

import pharmacy.entity.MedicamentStock;

public interface MedicamentStockDao extends CrudDao<Long, MedicamentStock>{

    MedicamentStock findMedicamentStock(Long id);
    
    List<MedicamentStock> findAll();
    
    List<MedicamentStock> GetMedicamentThatHaveExpired();
    
    List<MedicamentStock> GetMedicamentThatWillSoonExpire();

}

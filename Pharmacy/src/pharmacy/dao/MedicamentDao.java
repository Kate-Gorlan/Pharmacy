package pharmacy.dao;

import java.util.List;

import pharmacy.entity.Medicament;

public interface MedicamentDao extends CrudDao<Long, Medicament>{

    Medicament findMedicament(Long id);
    
    List<Medicament> findAll();

}

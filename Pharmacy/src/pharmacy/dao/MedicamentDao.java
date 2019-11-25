package pharmacy.dao;

import java.util.List;

import pharmacy.common.TopMedicament;
import pharmacy.entity.Medicament;
import pharmacy.common.MedCriticalNorm;

public interface MedicamentDao extends CrudDao<Long, Medicament>{

    Medicament findMedicament(Long id);
    
    List<Medicament> findAll();
    
    List<TopMedicament> getTopMedicament();
    
    List<TopMedicament> getTopMedicamentType(String type);
    
    List<Medicament> getMedOver();
    
    List<MedCriticalNorm> getReachedCriticalNorm();

}

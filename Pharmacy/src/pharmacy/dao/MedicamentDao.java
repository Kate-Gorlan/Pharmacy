package pharmacy.dao;

import java.util.List;

import pharmacy.common.TopMedicament;
import pharmacy.common.TopOverdueMed;
import pharmacy.entity.Medicament;
import pharmacy.common.ListMedicamentType;
import pharmacy.common.MedCriticalNorm;
import pharmacy.common.MedInfoAvailability;
import pharmacy.common.MedTechnology;
import pharmacy.common.MedTechnologyByName;
import pharmacy.common.MedTechnologyByType;
import pharmacy.common.MedicamentInfo;
import pharmacy.common.MedicamentIngredients;

public interface MedicamentDao extends CrudDao<Long, Medicament> {

    Medicament findMedicament(Long id);

    Medicament findByName(String name);
    
    MedInfoAvailability getMedInfoAvailability(Long idMed);
    
    List<Medicament> findByModOfAppl(String modOfAppl);
    
    List<Medicament> findByType(String type);
    
    List<Medicament> findByAvailabilityOfPrescription(String availabilityOfPrescription);
    
    List<Medicament> findByManufacturability(String manufacturability);
    
    List<Medicament> findAll();

    List<TopMedicament> getTopMedicament();

    List<TopMedicament> getTopMedicamentType(String type);

    List<Medicament> getMedOver();

    List<MedCriticalNorm> getReachedCriticalNorm();

    List<MedCriticalNorm> getMinMedInStockByType(String type);

    List<MedCriticalNorm> getMinMedInStock();

    List<MedTechnology> getTechnologyOrderInProduction();

    List<MedTechnologyByName> getTechnologyByName(String name);

    List<MedTechnologyByType> getTechnologyByType(String type);

    List<MedicamentInfo> getInfoMedicamentByName(String name);

    List<MedicamentIngredients> getIngredients(String name);

    List<ListMedicamentType> typeList();

    List<TopOverdueMed> overdueList();

    List<Medicament> searchMed(String str);

    Integer getQuantityMedPending(Long id);
}

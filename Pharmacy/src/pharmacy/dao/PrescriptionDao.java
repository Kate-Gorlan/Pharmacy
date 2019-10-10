package pharmacy.dao;

import java.util.List;

import pharmacy.entity.Prescription;

public interface PrescriptionDao extends CrudDao<Long, Prescription>{

    Prescription findPrescription(Long id);
    
    List<Prescription> findAll();

}

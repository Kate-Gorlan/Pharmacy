package pharmacy.dao;

import java.util.List;

import pharmacy.entity.Doctor;

public interface DoctorDao extends CrudDao<Long, Doctor>{

    Doctor findDoctor(Long id);
    
    List<Doctor> findAll();

}

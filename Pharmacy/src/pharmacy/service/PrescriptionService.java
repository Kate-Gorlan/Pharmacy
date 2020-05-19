package pharmacy.service;

import java.util.Collections;
import java.util.List;

import pharmacy.dao.PrescriptionDao;
import pharmacy.entity.Prescription;

public class PrescriptionService {

    private PrescriptionDao prescriptionDao;

    public PrescriptionDao getPrescriptionDao() {
        return prescriptionDao;
    }

    public void setPrescriptionDao(PrescriptionDao prescriptionDao) {
        this.prescriptionDao = prescriptionDao;
    }
    
    public void add(Prescription obj) {
        if (obj.getId() == null) {
            prescriptionDao.create(obj);
        } else {
            prescriptionDao.update(obj);
        }
    }

    public Prescription getById(Long id) {
        return prescriptionDao.read(id);
    }
    
    public List<Prescription> getAll(){
        List<Prescription> reversePrescription = prescriptionDao.findAll();
        Collections.reverse(reversePrescription);
        return reversePrescription;
    }
    
    public void deleteById(Long id) {
        prescriptionDao.delete(id);
    }
}

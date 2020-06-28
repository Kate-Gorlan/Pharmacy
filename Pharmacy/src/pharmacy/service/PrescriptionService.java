package pharmacy.service;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import pharmacy.dao.ClientDao;
import pharmacy.dao.DoctorDao;
import pharmacy.dao.MedicamentDao;
import pharmacy.dao.PrescriptionDao;
import pharmacy.entity.Client;
import pharmacy.entity.Doctor;
import pharmacy.entity.Medicament;
import pharmacy.entity.Prescription;

public class PrescriptionService {

    private PrescriptionDao prescriptionDao;
    
    private MedicamentDao medicamentDao;
    
    private ClientDao clientDao;
    
    private DoctorDao doctorDao;

    public PrescriptionDao getPrescriptionDao() {
        return prescriptionDao;
    }

    public void setPrescriptionDao(PrescriptionDao prescriptionDao) {
        this.prescriptionDao = prescriptionDao;
    }

    public MedicamentDao getMedicamentDao() {
        return medicamentDao;
    }

    public void setMedicamentDao(MedicamentDao medicamentDao) {
        this.medicamentDao = medicamentDao;
    }

    public ClientDao getClientDao() {
        return clientDao;
    }

    public void setClientDao(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    public DoctorDao getDoctorDao() {
        return doctorDao;
    }

    public void setDoctorDao(DoctorDao doctorDao) {
        this.doctorDao = doctorDao;
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
    
    public List<Prescription> getNew(){
        List<Prescription> reversePrescription = prescriptionDao.findNew();
        Collections.reverse(reversePrescription);
        return reversePrescription;
    }
    
    public void deleteById(Long id) {
        prescriptionDao.delete(id);
    }
    
    
     public ArrayList<String> check(Prescription prescr) throws UnsupportedEncodingException {
        this.decoding(prescr);
        ArrayList<String> errors = new ArrayList<String>();
        
        Long id = prescr.getMedicament().getId();
        Medicament med = medicamentDao.read(id);
        if (med == null) {
            errors.add("Запись о медикаменте не найдена");
        }
        
        Long idC = prescr.getClient().getId();
        Client cl = clientDao.read(idC);
        if (cl == null) {
            errors.add("Запись о клиенте не найдена");
        }
        
        Long idD = prescr.getDoctor().getId();
        Doctor doc = doctorDao.read(idD);
        if (doc == null) {
            errors.add("Запись о враче не найдена");
        }
        
        if (prescr.getAmountOfMedicine()<=0) {
            errors.add("Количество медикамента не может быть нулем или меньше нуля");
        }
        if (prescr.getSeal()==null) {
            errors.add("На рецепте от врача должна быть печать");
        } else if (prescr.getSeal().equals("0")) {
            errors.add("На рецепте от врача должна быть печать");
        }
        if (prescr.getSignature()==null) {
            errors.add("На рецепте от врача должна быть его роспись");
        } else if (prescr.getSignature().equals("0")) {
            errors.add("На рецепте от врача должна быть его роспись");
        }
        

        return errors;
    } 
      
     public void decoding(Prescription prescr) throws UnsupportedEncodingException {
        String diagn = new String(prescr.getDiagnosis().getBytes("iso-8859-1"), "utf-8");
        prescr.setDiagnosis(diagn);
    }
      
}

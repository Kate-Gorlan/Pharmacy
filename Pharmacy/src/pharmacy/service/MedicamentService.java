package pharmacy.service;

import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.List;

import pharmacy.common.MedCriticalNorm;
import pharmacy.common.MedTechnology;
import pharmacy.common.MedTechnologyByName;
import pharmacy.common.MedTechnologyByType;
import pharmacy.common.MedicamentInfo;
import pharmacy.common.MedicamentIngredients;
import pharmacy.common.TopMedicament;
import pharmacy.dao.MedicamentDao;
import pharmacy.entity.Medicament;

public class MedicamentService {

    private MedicamentDao medicamentDao;

    public MedicamentDao getMedicamentDao() {
        return medicamentDao;
    }

    public void setMedicamentDao(MedicamentDao medicamentDao) {
        this.medicamentDao = medicamentDao;
    }
    
    public void decoding(Medicament medicament) throws UnsupportedEncodingException {
        String name = new String(medicament.getName().getBytes("iso-8859-1"), "utf-8");
        medicament.setName(name);
        String type = new String(medicament.getType().getBytes("iso-8859-1"), "utf-8");
        medicament.setType(type);
        if (medicament.getModeOfApplication()!=null) {
            String mode = new String(medicament.getModeOfApplication().getBytes("iso-8859-1"), "utf-8");
            medicament.setModeOfApplication(mode);
        }
        if (medicament.getDescription()!=null) {
            String decode = new String(medicament.getDescription().getBytes("iso-8859-1"), "utf-8");
            medicament.setDescription(decode);
        }
        if (medicament.getIndications()!=null) {
            String decode = new String(medicament.getIndications().getBytes("iso-8859-1"), "utf-8");
            medicament.setIndications(decode);
        }
        if (medicament.getDosesAndMethodOfAppl()!=null) {
            String decode = new String(medicament.getDosesAndMethodOfAppl().getBytes("iso-8859-1"), "utf-8");
            medicament.setDosesAndMethodOfAppl(decode);
        }
        if (medicament.getContraindications()!=null) {
            String decode = new String(medicament.getContraindications().getBytes("iso-8859-1"), "utf-8");
            medicament.setContraindications(decode);
        }
        if (medicament.getPrecautions()!=null) {
            String decode = new String(medicament.getPrecautions().getBytes("iso-8859-1"), "utf-8");
            medicament.setPrecautions(decode);
        }
        if (medicament.getInteraction()!=null) {
            String decode = new String(medicament.getInteraction().getBytes("iso-8859-1"), "utf-8");
            medicament.setInteraction(decode);
        }
        if (medicament.getPregnancyAndBreastfeeding()!=null) {
            String decode = new String(medicament.getPregnancyAndBreastfeeding().getBytes("iso-8859-1"), "utf-8");
            medicament.setPregnancyAndBreastfeeding(decode);
        }
        if (medicament.getInfluenceTM()!=null) {
            String decode = new String(medicament.getInfluenceTM().getBytes("iso-8859-1"), "utf-8");
            medicament.setInfluenceTM(decode);
        }
        if (medicament.getSideEffect()!=null) {
            String decode = new String(medicament.getSideEffect().getBytes("iso-8859-1"), "utf-8");
            medicament.setSideEffect(decode);
        }
        if (medicament.getOverdose()!=null) {
            String decode = new String(medicament.getOverdose().getBytes("iso-8859-1"), "utf-8");
            medicament.setOverdose(decode);
        }
    }
    
    public void add(Medicament obj) {
        if (obj.getId() == null) {
            medicamentDao.create(obj);
        } else {
            medicamentDao.update(obj);
        }
    }
    
    public Medicament findByName(String name) {
        return medicamentDao.findByName(name);
    }
    
    public Medicament findByModOfAppl(String param) {
        return medicamentDao.findByModOfAppl(param);
    }
    
    public Medicament findByType(String param) {
        return medicamentDao.findByType(param);
    }
    
    public Medicament findByAvailabilityOfPrescription(String param) {
        return medicamentDao.findByAvailabilityOfPrescription(param);
    }
    
    public Medicament findByManufacturability(String param) {
        return medicamentDao.findByManufacturability(param);
    }
    
    public Medicament getById(Long id) {
        return medicamentDao.read(id);
    }
    
    public List<Medicament> getAll(){
        List<Medicament> reverse = medicamentDao.findAll();
        Collections.reverse(reverse);
        return reverse;
    }
    
    public void deleteById(Long id) {
        medicamentDao.delete(id);
    }
    
    public List<TopMedicament> getTopMedicament(){
        return medicamentDao.getTopMedicament();
    }
    
    public List<TopMedicament> getTopMedicamentType(String type){
        return medicamentDao.getTopMedicamentType(type);
    }
    
    public List<Medicament> getMedOver(){
        return medicamentDao.getMedOver();
    }
    
    public List<MedCriticalNorm> getReachedCriticalNorm(){
        return medicamentDao.getReachedCriticalNorm();
    }
    
    public List<MedCriticalNorm> getMinMedInStockByType(String type){
        return medicamentDao.getMinMedInStockByType(type);
    }
    
    public List<MedCriticalNorm> getMinMedInStock(){
        return medicamentDao.getMinMedInStock();
    }
    
    public List<MedTechnology> getTechnologyOrderInProduction(){
        return medicamentDao.getTechnologyOrderInProduction();
    }
    
    public List<MedTechnologyByName> getTechnologyByName(String name){
        return medicamentDao.getTechnologyByName(name);
    }
    
    public List<MedTechnologyByType> getTechnologyByType(String type){
        return medicamentDao.getTechnologyByType(type);
    }
    
    public List<MedicamentInfo> getInfoMedicamentByName(String name){
        return medicamentDao.getInfoMedicamentByName(name);
    }
    
    public List<MedicamentIngredients> getIngredients(String name){
        return medicamentDao.getIngredients(name);
    }
}

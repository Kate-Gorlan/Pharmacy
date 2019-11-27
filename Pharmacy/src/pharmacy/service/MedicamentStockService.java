package pharmacy.service;

import java.util.Collections;
import java.util.List;

import pharmacy.dao.MedicamentStockDao;
import pharmacy.entity.MedicamentStock;

public class MedicamentStockService {

    private MedicamentStockDao medicamentStockDao;

    public MedicamentStockDao getMedicamentStockDao() {
        return medicamentStockDao;
    }

    public void setMedicamentStockDao(MedicamentStockDao medicamentStockDao) {
        this.medicamentStockDao = medicamentStockDao;
    }
    
    public void add(MedicamentStock obj) {
        if (obj.getId() == null) {
            medicamentStockDao.create(obj);
        } else {
            medicamentStockDao.update(obj);
        }
    }
    
    public MedicamentStock getById(Long id) {
        return medicamentStockDao.read(id);
    }
    
    public List<MedicamentStock> getAll(){
        List<MedicamentStock> reverse = medicamentStockDao.findAll();
        Collections.reverse(reverse);
        return reverse;
    }
    
    public void deleteById(Long id) {
        medicamentStockDao.delete(id);
    }
}

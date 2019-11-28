package pharmacy.service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import pharmacy.dao.MedicamentDao;
import pharmacy.dao.MedicamentStockDao;
import pharmacy.entity.Medicament;
import pharmacy.entity.MedicamentStock;

public class MedicamentStockService {

    private MedicamentStockDao medicamentStockDao;
    
    private MedicamentDao medicamentDao;

    public MedicamentStockDao getMedicamentStockDao() {
        return medicamentStockDao;
    }

    public void setMedicamentStockDao(MedicamentStockDao medicamentStockDao) {
        this.medicamentStockDao = medicamentStockDao;
    }
    
    public MedicamentDao getMedicamentDao() {
        return medicamentDao;
    }

    public void setMedicamentDao(MedicamentDao medicamentDao) {
        this.medicamentDao = medicamentDao;
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
    
    public ArrayList<String> check(MedicamentStock medicamentStock) {
        ArrayList<String> errors = new ArrayList<String>();
        Long id = medicamentStock.getMedicament().getId();
        Medicament med = medicamentDao.read(id);
        if (med == null) {
            errors.add("Указанного медикамента нету в базе");
        }
        if (medicamentStock.getQuantity()<=0) {
            errors.add("Количество не может быть нулевым или отрицательным");
        }
        if (medicamentStock.getShelfLife()<=0) {
            errors.add("Срок годности не может быть нулевым или отрицательным");
        }
        try {
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(new String(medicamentStock.getDateOfArrival()));
        Date date1 = Calendar.getInstance().getTime();
        
        if (date1.getTime()<date.getTime()) {
            errors.add("Дата поставки не может быть больше текущей");
        }
        } catch (Exception e) {
            errors.add("Дата введена не в формате ГГГГ-ММ-ДД ");
        }
        
        if (medicamentStock.getCriticalNorm()<=0) {
            errors.add("Критическая норма медикамента не может быть нулевой или отрицательной");
        }

        return errors;
    }
}

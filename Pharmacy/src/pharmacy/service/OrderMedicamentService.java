package pharmacy.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import pharmacy.common.OrderCostInfo;
import pharmacy.dao.MedicamentDao;
import pharmacy.dao.OrderMedicamentDao;
import pharmacy.dao.PrescriptionDao;
import pharmacy.entity.Medicament;
import pharmacy.entity.OrderMedicament;
import pharmacy.entity.Prescription;

public class OrderMedicamentService {

    private OrderMedicamentDao orderMedicamentDao;
    
    private MedicamentDao medicamentDao;
    
    private PrescriptionDao prescriptionDao;

    public OrderMedicamentDao getOrderMedicamentDao() {
        return orderMedicamentDao;
    }

    public void setOrderMedicamentDao(OrderMedicamentDao orderMedicamentDao) {
        this.orderMedicamentDao = orderMedicamentDao;
    }
    
    public MedicamentDao getMedicamentDao() {
        return medicamentDao;
    }

    public void setMedicamentDao(MedicamentDao medicamentDao) {
        this.medicamentDao = medicamentDao;
    }

    public PrescriptionDao getPrescriptionDao() {
        return prescriptionDao;
    }

    public void setPrescriptionDao(PrescriptionDao prescriptionDao) {
        this.prescriptionDao = prescriptionDao;
    }

    public void add(OrderMedicament obj) {
        if (obj.getId() == null) {
            if (obj.getPrescription().getId() == 0) {
                orderMedicamentDao.createNotPrescription(obj);
            } else {
                orderMedicamentDao.create(obj);
            }
        } else {
            if (obj.getPrescription().getId() == 0) {
                orderMedicamentDao.updateNotPrescription(obj);
                } else {
                    orderMedicamentDao.update(obj);
                }
        }
    }
    
    public OrderMedicament getById(Long id) {
        return orderMedicamentDao.read(id);
    }
    
    public List<OrderMedicament> getAll(){
        List<OrderMedicament> reverse = orderMedicamentDao.findAll();
        Collections.reverse(reverse);
        return reverse;
    }
    
    public List<OrderMedicament> findAllByOrder(Long id){
        List<OrderMedicament> reverse = orderMedicamentDao.findAllByOrder(id);
        Collections.reverse(reverse);
        return reverse;
    }
    
    public void deleteById(Long id) {
        orderMedicamentDao.delete(id);
    }
    
    public List<OrderCostInfo> getOrderCostInfo(Long id){
        List<OrderCostInfo> list = orderMedicamentDao.getOrderCostInfo(id);
        for (OrderCostInfo info : list) {
            info.setCost(info.getCost().setScale(2, RoundingMode.UP));
        }
        return list;
    }
    
    public BigDecimal getCostByInfo(List<OrderCostInfo> list) {
        BigDecimal cost = new BigDecimal(0);
        for (OrderCostInfo info : list) {
            cost = cost.add(info.getCost());
        }
        cost = cost.setScale(2, RoundingMode.UP);
        return cost;
    }
    
    public ArrayList<String> check(OrderMedicament om) {
        ArrayList<String> errors = new ArrayList<String>();
        Long id = om.getMedicament().getId();
        Medicament med = medicamentDao.read(id);
        if (med == null) {
            errors.add("Запись о медикаменте не найдена");
        }
        Long idP = om.getPrescription().getId();
        if (idP != 0) {
            Prescription pr = prescriptionDao.read(idP);
            if (pr == null) {
                errors.add("Запись о рецепте не найдена");
            }
        }
        
        if (om.getQuantity()<=0) {
            errors.add("Количество медикамента не может быть нулем или меньше нуля");
        }

        return errors;
    }
}

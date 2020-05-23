package pharmacy.service;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import pharmacy.common.OrderCostInfo;
import pharmacy.dao.OrderMedicamentDao;
import pharmacy.entity.OrderMedicament;

public class OrderMedicamentService {

    private OrderMedicamentDao orderMedicamentDao;

    public OrderMedicamentDao getOrderMedicamentDao() {
        return orderMedicamentDao;
    }

    public void setOrderMedicamentDao(OrderMedicamentDao orderMedicamentDao) {
        this.orderMedicamentDao = orderMedicamentDao;
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
        return orderMedicamentDao.getOrderCostInfo(id);
    }
    
    public BigDecimal getCostByInfo(List<OrderCostInfo> list) {
        BigDecimal cost = new BigDecimal(0);
        for (OrderCostInfo info : list) {
            cost = cost.add(info.getCost());
        }
        return cost;
    }
}

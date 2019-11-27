package pharmacy.service;

import java.util.Collections;
import java.util.List;

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
            orderMedicamentDao.create(obj);
        } else {
            orderMedicamentDao.update(obj);
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
    
    public void deleteById(Long id) {
        orderMedicamentDao.delete(id);
    }
}

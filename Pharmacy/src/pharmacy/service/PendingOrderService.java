package pharmacy.service;

import java.util.Collections;
import java.util.List;

import pharmacy.common.OrderInProduction;
import pharmacy.dao.PendingOrderDao;
import pharmacy.entity.PendingOrder;

public class PendingOrderService {

    private PendingOrderDao pendingOrderDao;

    public PendingOrderDao getPendingOrderDao() {
        return pendingOrderDao;
    }

    public void setPendingOrderDao(PendingOrderDao pendingOrderDao) {
        this.pendingOrderDao = pendingOrderDao;
    }
    
    public void add(PendingOrder obj) {
        if (obj.getId() == null) {
            pendingOrderDao.create(obj);
        } else {
            pendingOrderDao.update(obj);
        }
    }
    
    public PendingOrder getById(Long id) {
        return pendingOrderDao.read(id);
    }
    
    public List<PendingOrder> getAll(){
        List<PendingOrder> reverse = pendingOrderDao.findAll();
        Collections.reverse(reverse);
        return reverse;
    }
    
    public void deleteById(Long id) {
        pendingOrderDao.delete(id);
    }
    
    public List<OrderInProduction> getOrderInProduction(){
        return pendingOrderDao.getOrderInProduction();
    }
    
    public int getNumberOfOrderInProduction(){
        return pendingOrderDao.getNumberOfOrderInProduction();
    }
}

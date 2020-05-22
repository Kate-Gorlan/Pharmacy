package pharmacy.dao;

import java.util.List;

import pharmacy.entity.PendingOrder;
import pharmacy.common.OrderInProduction;
import pharmacy.common.PendingOrderEmployee;

public interface PendingOrderDao extends CrudDao<Long, PendingOrder>{

    PendingOrder findPendingOrder(Long id);
    
    List<PendingOrder> findAll();
    
    List<OrderInProduction> getOrderInProduction();
    
    int getNumberOfOrderInProduction();
    
    List<PendingOrderEmployee> findByEmployee(Long id);
    
    void createNotEmpl(PendingOrder obj);
    
    void updateNotEmpl(PendingOrder obj);
    
    PendingOrder getByIdOrder(Long idO);

}

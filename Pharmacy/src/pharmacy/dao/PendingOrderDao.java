package pharmacy.dao;

import java.util.List;

import pharmacy.entity.PendingOrder;
import pharmacy.common.OrderInProduction;

public interface PendingOrderDao extends CrudDao<Long, PendingOrder>{

    PendingOrder findPendingOrder(Long id);
    
    List<PendingOrder> findAll();
    
    List<OrderInProduction> getOrderInProduction();
    
    int getNumberOfOrderInProduction();

}

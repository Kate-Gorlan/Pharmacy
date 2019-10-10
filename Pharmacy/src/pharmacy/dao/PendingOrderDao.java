package pharmacy.dao;

import java.util.List;

import pharmacy.entity.PendingOrder;

public interface PendingOrderDao extends CrudDao<Long, PendingOrder>{

    PendingOrder findPendingOrder(Long id);
    
    List<PendingOrder> findAll();

}

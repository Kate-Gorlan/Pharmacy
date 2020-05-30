package pharmacy.dao;

import java.util.List;

import pharmacy.entity.Order;

public interface OrderDao extends CrudDao<Long, Order>{

    void createWithClient(Order obj);
    
    void updateWithClient(Order obj);
    
    Order findOrder(Long id);
    
    Order findByEmpl(Long id);
    
    List<Order> findAll();
    
    List<Order> findNotSale();
    
    List<Order> findSale();
}

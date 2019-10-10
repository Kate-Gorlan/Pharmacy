package pharmacy.dao;

import java.util.List;

import pharmacy.entity.Order;

public interface OrderDao extends CrudDao<Long, Order>{

    Order findOrder(Long id);
    
    List<Order> findAll();
}

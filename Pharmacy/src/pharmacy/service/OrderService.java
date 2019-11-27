package pharmacy.service;

import java.util.Collections;
import java.util.List;

import pharmacy.dao.OrderDao;
import pharmacy.entity.Order;

public class OrderService {

    private OrderDao orderDao;

    public OrderDao getOrderDao() {
        return orderDao;
    }

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }
    
    public void add(Order obj) {
        if (obj.getId() == null) {
            orderDao.create(obj);
        } else {
            orderDao.update(obj);
        }
    }
    
    public Order getById(Long id) {
        return orderDao.read(id);
    }
    
    public List<Order> getAll(){
        List<Order> reverse = orderDao.findAll();
        Collections.reverse(reverse);
        return reverse;
    }
    
    public void deleteById(Long id) {
        orderDao.delete(id);
    }
}

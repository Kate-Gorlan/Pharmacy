package pharmacy.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import pharmacy.dao.ClientDao;
import pharmacy.dao.EmployeeDao;
import pharmacy.dao.OrderDao;
import pharmacy.entity.Client;
import pharmacy.entity.Employee;
import pharmacy.entity.Order;

public class OrderService {

    private OrderDao orderDao;
    
    private EmployeeDao employeeDao;
    
    private ClientDao clientDao;

    public OrderDao getOrderDao() {
        return orderDao;
    }

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }
    
    public EmployeeDao getEmployeeDao() {
        return employeeDao;
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
    
    /*public void add(Order obj) {
        if (obj.getId() == null) {
            orderDao.create(obj);
        } else {
            orderDao.update(obj);
        }
    }*/
    
    public ClientDao getClientDao() {
        return clientDao;
    }

    public void setClientDao(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    public void add(Order obj) {
        if (obj.getId() == null) {
            if (obj.getClient().getId() != 0) {
                orderDao.createWithClient(obj);
            } else {
                orderDao.create(obj);
            }
        } else {
            if (obj.getClient().getId() != 0) {
                orderDao.updateWithClient(obj);
                } else {
                    orderDao.update(obj);
                }
        }
    }
    
    public Order getById(Long id) {
        return orderDao.read(id);
    }
    
    public Order findByEmpl(Long id) {
        return orderDao.findByEmpl(id);
    }
    
    public List<Order> getAll(){
        List<Order> reverse = orderDao.findAll();
        Collections.reverse(reverse);
        return reverse;
    }
    
    public void deleteById(Long id) {
        orderDao.delete(id);
    }
    
    public ArrayList<String> check(Order order) {
        ArrayList<String> errors = new ArrayList<String>();
        
        Long id = order.getEmployee().getId();
        Employee empl = employeeDao.read(id);
        if (empl == null) {
            errors.add("Запись о работнике не найдена");
        }
        
        if(order.getClient().getId()!=0){
            Long idClient = order.getClient().getId();
            Client cl = clientDao.read(idClient);
            if (cl == null) {
                errors.add("Запись о клиенте не найдена");
            }
        } 

        return errors;
    }
}

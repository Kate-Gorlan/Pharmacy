package pharmacy.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import pharmacy.dao.EmployeeDao;
import pharmacy.dao.OrderDao;
import pharmacy.entity.Employee;
import pharmacy.entity.Order;

public class OrderService {

    private OrderDao orderDao;
    
    private EmployeeDao employeeDao;

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
    
    public ArrayList<String> check(Order order) {
        ArrayList<String> errors = new ArrayList<String>();
        Long id = order.getEmployee().getId();
        Employee empl = employeeDao.read(id);
        if (empl == null) {
            errors.add("Запись о работнике не найдена");
        }
        if(!"".equals(order.getDate())) {
        try {
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(new String(order.getDate()));
        Date date1 = Calendar.getInstance().getTime();
        
        if (date1.getTime()<date.getTime()) {
            errors.add("Дата не может быть больше текущей");
        }
        } catch (Exception e) {
            errors.add("Дата введена не в формате yyyy-MM-dd");
        }
        }

        return errors;
    }
}

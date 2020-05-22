package pharmacy.service;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import pharmacy.common.OrderInProduction;
import pharmacy.common.PendingOrderEmployee;
import pharmacy.dao.EmployeeDao;
import pharmacy.dao.PendingOrderDao;
import pharmacy.entity.Employee;
import pharmacy.entity.PendingOrder;

public class PendingOrderService {

    private PendingOrderDao pendingOrderDao;
    
    private EmployeeDao employeeDao;

    public PendingOrderDao getPendingOrderDao() {
        return pendingOrderDao;
    }

    public void setPendingOrderDao(PendingOrderDao pendingOrderDao) {
        this.pendingOrderDao = pendingOrderDao;
    }
    
    public EmployeeDao getEmployeeDao() {
        return employeeDao;
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
    
    public void add(PendingOrder obj) {
        if (obj.getId() == null) {
            if (obj.getEmployee().getId() == 0) {
                pendingOrderDao.createNotEmpl(obj);
            } else {
                pendingOrderDao.create(obj);
            }
        } else {
            if (obj.getEmployee().getId() == 0) {
                pendingOrderDao.updateNotEmpl(obj);
                } else {
                    pendingOrderDao.update(obj);
                }
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
    
    public void decoding(PendingOrder orderPend) throws UnsupportedEncodingException {
        String takeStatus = new String(orderPend.getTakeStatus().getBytes("iso-8859-1"), "utf-8");
        orderPend.setTakeStatus(takeStatus);
    }
    
    public ArrayList<String> check(PendingOrder orderPend) throws UnsupportedEncodingException {
        this.decoding(orderPend);
        ArrayList<String> errors = new ArrayList<String>();
        if(orderPend.getEmployee().getId()!=0){
        Long id = orderPend.getEmployee().getId();
        Employee empl = employeeDao.read(id);
        if (empl == null) {
            errors.add("Запись о работнике не найдена");
        }}
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(new String(orderPend.getAvailabilityDate()));
            Date date1 = Calendar.getInstance().getTime();
            
            if (date1.getTime()>date.getTime()) {
                errors.add("Дата не может быть меньше текущей");
            }
            } catch (Exception e) {
                errors.add("Дата введена не в формате yyyy-MM-dd");
            }

        return errors;
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
    
    public List<PendingOrderEmployee> findByEmployee(Long id){
        return pendingOrderDao.findByEmployee(id);
    }
    
    public PendingOrder getByIdOrder(Long idO) {
        return pendingOrderDao.getByIdOrder(idO);
    }
}

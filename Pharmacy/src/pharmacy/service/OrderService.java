package pharmacy.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import pharmacy.common.MedInfoAvailability;
import pharmacy.dao.ClientDao;
import pharmacy.dao.EmployeeDao;
import pharmacy.dao.MedicamentDao;
import pharmacy.dao.OrderDao;
import pharmacy.dao.OrderMedicamentDao;
import pharmacy.dao.PendingOrderDao;
import pharmacy.dao.SaleDao;
import pharmacy.entity.Client;
import pharmacy.entity.Employee;
import pharmacy.entity.Order;
import pharmacy.entity.OrderMedicament;

public class OrderService {

    private OrderDao orderDao;
    
    private SaleDao saleDao;
    
    private MedicamentDao medicamentDao;
    
    private OrderMedicamentDao orderMedicamentDao;
    
    private EmployeeDao employeeDao;
    
    private ClientDao clientDao;
    
    private PendingOrderDao pendingOrderDao;

    public SaleDao getSaleDao() {
        return saleDao;
    }

    public void setSaleDao(SaleDao saleDao) {
        this.saleDao = saleDao;
    }

    public PendingOrderDao getPendingOrderDao() {
        return pendingOrderDao;
    }

    public void setPendingOrderDao(PendingOrderDao pendingOrderDao) {
        this.pendingOrderDao = pendingOrderDao;
    }

    public OrderDao getOrderDao() {
        return orderDao;
    }

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }
    
    public MedicamentDao getMedicamentDao() {
        return medicamentDao;
    }

    public void setMedicamentDao(MedicamentDao medicamentDao) {
        this.medicamentDao = medicamentDao;
    }

    public OrderMedicamentDao getOrderMedicamentDao() {
        return orderMedicamentDao;
    }

    public void setOrderMedicamentDao(OrderMedicamentDao orderMedicamentDao) {
        this.orderMedicamentDao = orderMedicamentDao;
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
    
    public List<Order> getNotSale(){
        List<Order> reverse = orderDao.findNotSale();
        Collections.reverse(reverse);
        return reverse;
    }
    
    public List<Order> getSale(){
        List<Order> reverse = orderDao.findSale();
        Collections.reverse(reverse);
        return reverse;
    }
    
    public void deleteById(Long id) {
        orderDao.delete(id);
    }
    
    public boolean buttonSale(Long id) {

        boolean checkSale = false;
        try {
            Long idSale = saleDao.findByOrder(id).getId();
        }catch (Exception e) {
            checkSale = true;
        }
        if(checkSale) {
        List<OrderMedicament> medsOrder = orderMedicamentDao.findAllByOrder(id);
        int medsNum = medsOrder.size();
        int check = 0;
        
        for (OrderMedicament orderMedicament : medsOrder) {
            
            Long idMed = orderMedicament.getMedicament().getId();
            MedInfoAvailability medInfo = medicamentDao.getMedInfoAvailability(idMed);
            Integer quantity = orderMedicament.getQuantity();
            Integer quantityInStock = medInfo.getQuantity();
            Integer medPend = medicamentDao.getQuantityMedPending(idMed);
            
            Long idPO =  (long)0;
            boolean checkPO = false;
            try {
                idPO = pendingOrderDao.getByIdOrder(id).getId();

            } catch (Exception e) {
                checkPO = true;
            }
            
            if(!checkPO) {
                boolean checkEmpl = false;
                try {
                    Long idEmpl = pendingOrderDao.read(idPO).getEmployee().getId();
                } catch (Exception e) {
                    checkEmpl = true;
                }
                
                if(!checkEmpl && pendingOrderDao.read(idPO).getTakeStatus().equals("В ожидании")) {
                    return false;
                }
            }
            
            if(!checkPO) {
                medPend = medPend - quantity;
            }
            
            if (quantityInStock-medPend>=quantity) {
                check = check + 1;
            }
        }
        
        if (check==medsNum) return true;
        else return false;
        } 
        else return false;
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

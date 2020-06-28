package pharmacy.service;

import java.util.Collections;
import java.util.List;

import pharmacy.dao.EmployeeDao;
import pharmacy.entity.Employee;

public class EmployeeService {

    private EmployeeDao employeeDao;

    public EmployeeDao getEmployeeDao() {
        return employeeDao;
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
    
    public void add(Employee obj) {
        if (obj.getId() == null) {
            employeeDao.create(obj);
        } else {
            employeeDao.update(obj);
        }
    }
    
    public Employee getById(Long id) {
        return employeeDao.read(id);
    }
    
    public Employee getByUser(Long id) {
        return employeeDao.getByUser(id);
    }
    
    public List<Employee> getAll(){
        List<Employee> reverse = employeeDao.findAll();
        Collections.reverse(reverse);
        return reverse;
    }
    
    public void deleteById(Long id) {
        employeeDao.delete(id);
    }
    
    public List<Employee> getByPosition(String title){
        List<Employee> list = employeeDao.findByPosition(title);
        return list;
    }

}

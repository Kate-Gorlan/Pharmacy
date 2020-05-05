package pharmacy.dao;

import java.util.List;

import pharmacy.entity.Employee;

public interface EmployeeDao extends CrudDao<Long, Employee>{

    Employee findEmployee(Long id);
    
    List<Employee> findAll();

    List<Employee> findByPosition(String title);

}

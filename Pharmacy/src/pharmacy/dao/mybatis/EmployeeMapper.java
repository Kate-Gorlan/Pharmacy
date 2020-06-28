package pharmacy.dao.mybatis;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import pharmacy.dao.EmployeeDao;
import pharmacy.entity.Employee;

public class EmployeeMapper extends SqlSessionDaoSupport implements EmployeeDao{

    @Override
    public void create(Employee obj) {
        getSqlSession().insert("pharmacy.dao.EmployeeDao.create", obj);
    }

    @Override
    public Employee read(Long id) {
        return getSqlSession().selectOne("pharmacy.dao.EmployeeDao.read", id);
    }

    @Override
    public void update(Employee obj) {
        getSqlSession().update("pharmacy.dao.EmployeeDao.update", obj);
    }

    @Override
    public void delete(Long id) {
        getSqlSession().delete("pharmacy.dao.EmployeeDao.delete", id);
    }

    @Override
    public Employee findEmployee(Long id) {
        return getSqlSession().selectOne("pharmacy.dao.EmployeeDao.findById", id);
    }

    @Override
    public List<Employee> findAll() {
        return getSqlSession().selectList("pharmacy.dao.EmployeeDao.findAll");
    }

    @Override
    public List<Employee> findByPosition(String title) {
        return getSqlSession().selectList("pharmacy.dao.EmployeeDao.findByPosition", title);
    }

    @Override
    public Employee getByUser(Long id) {
        return getSqlSession().selectOne("pharmacy.dao.EmployeeDao.getByUser", id);
    }
} 

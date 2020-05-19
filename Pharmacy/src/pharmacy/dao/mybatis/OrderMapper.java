package pharmacy.dao.mybatis;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import pharmacy.dao.OrderDao;
import pharmacy.entity.Order;

public class OrderMapper extends SqlSessionDaoSupport implements OrderDao{

    @Override
    public void create(Order obj) {
        getSqlSession().insert("pharmacy.dao.OrderDao.create", obj);
    }

    @Override
    public Order read(Long id) {
        return getSqlSession().selectOne("pharmacy.dao.OrderDao.read", id);
    }

    @Override
    public void update(Order obj) {
        getSqlSession().update("pharmacy.dao.OrderDao.update", obj);
    }

    @Override
    public void delete(Long id) {
        getSqlSession().delete("pharmacy.dao.OrderDao.delete", id);
    }

    @Override
    public Order findOrder(Long id) {
        return getSqlSession().selectOne("pharmacy.dao.OrderDao.findById", id);
    }

    @Override
    public List<Order> findAll() {
        return getSqlSession().selectList("pharmacy.dao.OrderDao.findAll");
    }

    @Override
    public void createWithClient(Order obj) {
        getSqlSession().insert("pharmacy.dao.OrderDao.createWithClient", obj);
    }

    @Override
    public void updateWithClient(Order obj) {
        getSqlSession().update("pharmacy.dao.OrderDao.updateWithClient", obj);
    }

    @Override
    public Order findByEmpl(Long id) {
        return getSqlSession().selectOne("pharmacy.dao.OrderDao.findByEmpl", id);
    }
} 

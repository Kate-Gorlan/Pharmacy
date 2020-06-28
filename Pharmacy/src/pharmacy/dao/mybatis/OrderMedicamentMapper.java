package pharmacy.dao.mybatis;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import pharmacy.common.OrderCostInfo;
import pharmacy.dao.OrderMedicamentDao;
import pharmacy.entity.OrderMedicament;

public class OrderMedicamentMapper extends SqlSessionDaoSupport implements OrderMedicamentDao{

    @Override
    public void create(OrderMedicament obj) {
        getSqlSession().insert("pharmacy.dao.OrderMedicamentDao.create", obj);
    }

    @Override
    public OrderMedicament read(Long id) {
        return getSqlSession().selectOne("pharmacy.dao.OrderMedicamentDao.read", id);
    }

    @Override
    public void update(OrderMedicament obj) {
        getSqlSession().update("pharmacy.dao.OrderMedicamentDao.update", obj);
    }

    @Override
    public void delete(Long id) {
        getSqlSession().delete("pharmacy.dao.OrderMedicamentDao.delete", id);
    }

    @Override
    public OrderMedicament findOrderMedicament(Long id) {
        return getSqlSession().selectOne("pharmacy.dao.OrderMedicamentDao.findById", id);
    }

    @Override
    public List<OrderMedicament> findAll() {
        return getSqlSession().selectList("pharmacy.dao.OrderMedicamentDao.findAll");
    }

    @Override
    public List<OrderMedicament> findAllByOrder(Long id) {
        return getSqlSession().selectList("pharmacy.dao.OrderMedicamentDao.findAllByOrder", id);
    }

    @Override
    public void createNotPrescription(OrderMedicament obj) {
        getSqlSession().insert("pharmacy.dao.OrderMedicamentDao.createNotPrescription", obj);
    }

    @Override
    public void updateNotPrescription(OrderMedicament obj) {
        getSqlSession().update("pharmacy.dao.OrderMedicamentDao.updateNotPrescription", obj);
    }

    @Override
    public List<OrderCostInfo> getOrderCostInfo(Long id) {
        return getSqlSession().selectList("pharmacy.dao.OrderMedicamentDao.getOrderCostInfo", id);
    }
} 

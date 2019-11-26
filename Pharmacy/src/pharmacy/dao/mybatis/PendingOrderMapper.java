package pharmacy.dao.mybatis;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import pharmacy.common.OrderInProduction;
import pharmacy.dao.PendingOrderDao;
import pharmacy.entity.PendingOrder;

public class PendingOrderMapper extends SqlSessionDaoSupport implements PendingOrderDao{

    @Override
    public void create(PendingOrder obj) {
        getSqlSession().insert("pharmacy.dao.PendingOrderDao.create", obj);
    }

    @Override
    public PendingOrder read(Long id) {
        return getSqlSession().selectOne("pharmacy.dao.PendingOrderDao.read", id);
    }

    @Override
    public void update(PendingOrder obj) {
        getSqlSession().update("pharmacy.dao.PendingOrderDao.update", obj);
    }

    @Override
    public void delete(Long id) {
        getSqlSession().delete("pharmacy.dao.PendingOrderDao.delete", id);
    }

    @Override
    public PendingOrder findPendingOrder(Long id) {
        return getSqlSession().selectOne("pharmacy.dao.PendingOrderDao.findById", id);
    }

    @Override
    public List<PendingOrder> findAll() {
        return getSqlSession().selectList("pharmacy.dao.PendingOrderDao.findAll");
    }

    @Override
    public List<OrderInProduction> getOrderInProduction() {
        return getSqlSession().selectList("pharmacy.dao.PendingOrderDao.GetOrderInProduction");
    }

    @Override
    public int getNumberOfOrderInProduction() {
        return getSqlSession().selectOne("pharmacy.dao.PendingOrderDao.GetNumberOfOrderInProduction");
    }
} 

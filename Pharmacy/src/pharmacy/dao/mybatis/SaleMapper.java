package pharmacy.dao.mybatis;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import pharmacy.dao.SaleDao;
import pharmacy.entity.Sale;

public class SaleMapper extends SqlSessionDaoSupport implements SaleDao{

    @Override
    public void create(Sale obj) {
        getSqlSession().insert("pharmacy.dao.SaleDao.create", obj);
    }

    @Override
    public Sale read(Long id) {
        return getSqlSession().selectOne("pharmacy.dao.SaleDao.read", id);
    }

    @Override
    public void update(Sale obj) {
        getSqlSession().update("pharmacy.dao.SaleDao.update", obj);
    }

    @Override
    public void delete(Long id) {
        getSqlSession().delete("pharmacy.dao.SaleDao.delete", id);
    }

    @Override
    public List<Sale> findAll() {
        return getSqlSession().selectList("pharmacy.dao.SaleDao.findAll");
    }

    @Override
    public Integer addSale(Long id) {
        return getSqlSession().selectOne("pharmacy.dao.SaleDao.addSale", id);
    }

} 

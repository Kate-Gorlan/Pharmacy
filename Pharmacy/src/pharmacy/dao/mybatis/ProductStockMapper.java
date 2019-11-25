package pharmacy.dao.mybatis;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import pharmacy.dao.ProductStockDao;
import pharmacy.entity.ProductStock;

public class ProductStockMapper extends SqlSessionDaoSupport implements ProductStockDao{

    @Override
    public void create(ProductStock obj) {
        getSqlSession().insert("pharmacy.dao.ProductStockDao.create", obj);
    }

    @Override
    public ProductStock read(Long id) {
        return getSqlSession().selectOne("pharmacy.dao.ProductStockDao.read", id);
    }

    @Override
    public void update(ProductStock obj) {
        getSqlSession().update("pharmacy.dao.ProductStockDao.update", obj);
    }

    @Override
    public void delete(Long id) {
        getSqlSession().delete("pharmacy.dao.ProductStockDao.delete", id);
    }

    @Override
    public ProductStock findProductStock(Long id) {
        return getSqlSession().selectOne("pharmacy.dao.ProductStockDao.findById", id);
    }

    @Override
    public List<ProductStock> findAll() {
        return getSqlSession().selectList("pharmacy.dao.ProductStockDao.findAll");
    }
} 

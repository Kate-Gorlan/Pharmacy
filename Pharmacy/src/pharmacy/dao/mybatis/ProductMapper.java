package pharmacy.dao.mybatis;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import pharmacy.common.ProductCriticalNorm;
import pharmacy.dao.ProductDao;
import pharmacy.entity.Product;

public class ProductMapper extends SqlSessionDaoSupport implements ProductDao{

    @Override
    public void create(Product obj) {
        getSqlSession().insert("pharmacy.dao.ProductDao.create", obj);
    }

    @Override
    public Product read(Long id) {
        return getSqlSession().selectOne("pharmacy.dao.ProductDao.read", id);
    }

    @Override
    public void update(Product obj) {
        getSqlSession().update("pharmacy.dao.ProductDao.update", obj);
    }

    @Override
    public void delete(Long id) {
        getSqlSession().delete("pharmacy.dao.ProductDao.delete", id);
    }

    @Override
    public Product findProduct(Long id) {
        return getSqlSession().selectOne("pharmacy.dao.ProductDao.findById", id);
    }

    @Override
    public List<Product> findAll() {
        return getSqlSession().selectList("pharmacy.dao.ProductDao.findAll");
    }
    
    @Override
    public int getVolumeOfProductUsed(String productName) {
        return getSqlSession().selectOne("pharmacy.dao.ProductDao.volumeOfProductUsed", productName);
    }
    
    @Override
    public int getVolumeOfPUForThePeriod(HashMap<String, Object> values) {
        return getSqlSession().selectOne("pharmacy.dao.ProductDao.GetVolumeOfPUForThePeriod", values);
    }

    @Override
    public List<Product> getProdOver() {
        return getSqlSession().selectList("pharmacy.dao.ProductDao.GetProdOver");
    }

    @Override
    public List<ProductCriticalNorm> getReachedCriticalNormProduct() {
        return getSqlSession().selectList("pharmacy.dao.ProductDao.GetReachedCriticalNormProduct");
    }
} 

package pharmacy.service;

import java.util.Collections;
import java.util.List;

import pharmacy.dao.ProductStockDao;
import pharmacy.entity.ProductStock;

public class ProductStockService {

    private ProductStockDao productStockDao;

    public ProductStockDao getProductStockDao() {
        return productStockDao;
    }

    public void setProductStockDao(ProductStockDao productStockDao) {
        this.productStockDao = productStockDao;
    }
    
    public void add(ProductStock obj) {
        if (obj.getId() == null) {
            productStockDao.create(obj);
        } else {
            productStockDao.update(obj);
        }
    }
    
    public ProductStock getById(Long id) {
        return productStockDao.read(id);
    }
    
    public List<ProductStock> getAll(){
        List<ProductStock> reverse = productStockDao.findAll();
        Collections.reverse(reverse);
        return reverse;
    }
    
    public void deleteById(Long id) {
        productStockDao.delete(id);
    }

}

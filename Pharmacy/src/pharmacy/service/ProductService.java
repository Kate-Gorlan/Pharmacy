package pharmacy.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import pharmacy.common.ProductCriticalNorm;
import pharmacy.dao.ProductDao;
import pharmacy.entity.Product;

public class ProductService {

    private ProductDao productDao;

    public ProductDao getProductDao() {
        return productDao;
    }

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }
    
    public void add(Product obj) {
        if (obj.getId() == null) {
            productDao.create(obj);
        } else {
            productDao.update(obj);
        }
    }
    
    public Product getById(Long id) {
        return productDao.read(id);
    }
    
    public List<Product> getAll(){
        List<Product> reverse = productDao.findAll();
        Collections.reverse(reverse);
        return reverse;
    }
    
    public void deleteById(Long id) {
        productDao.delete(id);
    }

    public int getVolumeOfProductUsed(String productName){
        return productDao.getVolumeOfProductUsed(productName);
    }
    
    public int getVolumeOfPUForThePeriod(HashMap<String, Object> values){
        return productDao.getVolumeOfPUForThePeriod(values);
    }
    
    public List<Product> getProdOver(){
        return productDao.getProdOver();
    }
    
    public List<ProductCriticalNorm> getReachedCriticalNormProduct(){
        return productDao.getReachedCriticalNormProduct();
    }
    
    public List<ProductCriticalNorm> getMinProductInStockByType(String type){
        return productDao.getMinProductInStockByType(type);
    }
    
    public List<ProductCriticalNorm> getMinProductInStock(){
        return productDao.getMinProductInStock();
    }
    
    public List<ProductCriticalNorm> getProductForOrderInProduction(){
        return productDao.getProductForOrderInProduction();
    }
}

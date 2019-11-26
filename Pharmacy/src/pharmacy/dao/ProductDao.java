package pharmacy.dao;

import java.util.HashMap;
import java.util.List;

import pharmacy.entity.Product;
import pharmacy.common.ProductCriticalNorm;

public interface ProductDao extends CrudDao<Long, Product>{

    Product findProduct(Long id);
    
    List<Product> findAll();
    
    int getVolumeOfProductUsed(String productName);
    
    int getVolumeOfPUForThePeriod(HashMap<String, Object> values);
    
    List<Product> getProdOver();
    
    List<ProductCriticalNorm> getReachedCriticalNormProduct();
    
    List<ProductCriticalNorm> getMinProductInStockByType(String type);
    
    List<ProductCriticalNorm> getMinProductInStock();
    
    List<ProductCriticalNorm> getProductForOrderInProduction();

}

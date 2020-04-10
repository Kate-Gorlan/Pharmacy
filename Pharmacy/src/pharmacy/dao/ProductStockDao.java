package pharmacy.dao;

import java.util.List;

import pharmacy.entity.ProductStock;

public interface ProductStockDao extends CrudDao<Long, ProductStock>{

    ProductStock findProductStock(Long id);
    
    List<ProductStock> findAll();
    
    List<ProductStock> GetProductThatHaveExpired();
    
    List<ProductStock> GetProductThatWillSoonExpire();

}

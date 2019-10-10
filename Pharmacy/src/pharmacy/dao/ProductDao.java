package pharmacy.dao;

import java.util.List;

import pharmacy.entity.Product;

public interface ProductDao extends CrudDao<Long, Product>{

    Product findProduct(Long id);
    
    List<Product> findAll();

}

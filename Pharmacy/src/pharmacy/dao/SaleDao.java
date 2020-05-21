package pharmacy.dao;

import java.util.List;

import pharmacy.entity.Sale;

public interface SaleDao extends CrudDao<Long, Sale>{
    
    List<Sale> findAll();

}

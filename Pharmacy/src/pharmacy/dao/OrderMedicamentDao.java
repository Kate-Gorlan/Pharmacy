package pharmacy.dao;

import java.util.List;

import pharmacy.entity.OrderMedicament;

public interface OrderMedicamentDao extends CrudDao<Long, OrderMedicament>{

    OrderMedicament findOrderMedicament(Long id);
    
    List<OrderMedicament> findAll();
    
    List<OrderMedicament> findAllByOrder(Long id);

}

package pharmacy.service;

import java.util.Collections;
import java.util.List;

import pharmacy.dao.SaleDao;
import pharmacy.entity.Sale;

public class SaleService {

    private SaleDao saleDao;

    public SaleDao getSaleDao() {
        return saleDao;
    }

    public void setSaleDao(SaleDao saleDao) {
        this.saleDao = saleDao;
    }
    
    /*public void add(Sale obj) {
        if (obj.getId() == null) {
            saleDao.create(obj);
        } else {
            saleDao.update(obj);
        }
    }*/
    
    public void add(Long idOrder) {
        saleDao.addSale(idOrder);
    }
    
    public Sale getById(Long id) {
        return saleDao.read(id);
    }
    
    public List<Sale> getAll(){
        List<Sale> reverse = saleDao.findAll();
        Collections.reverse(reverse);
        return reverse;
    }
    
    public void deleteById(Long id) {
        saleDao.delete(id);
    }
    
    public Sale getByOrderId(Long id) {
        return saleDao.findByOrder(id);
    }


}

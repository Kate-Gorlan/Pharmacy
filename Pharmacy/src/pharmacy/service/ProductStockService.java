package pharmacy.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import pharmacy.dao.ProductDao;
import pharmacy.dao.ProductStockDao;
import pharmacy.entity.Product;
import pharmacy.entity.ProductStock;

public class ProductStockService {

    private ProductStockDao productStockDao;
    
    private ProductDao productDao;

    public ProductDao getProductDao() {
        return productDao;
    }

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }
    
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
    
    public ArrayList<String> check(ProductStock productStock) {
        ArrayList<String> errors = new ArrayList<String>();
        Long id = productStock.getProduct().getId();
        Product prod = productDao.read(id);
        if (prod == null) {
            errors.add("Запись о продукте не найдена");
        }
        if (productStock.getQuantity()<=0) {
            errors.add("Количество продукта не может быть нулем или меньше нуля");
        }
        if (productStock.getShelfLife()<=0) {
            errors.add("Срок годности продукта не может быть нулем или меньше нуля");
        }
        try {
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(new String(productStock.getDateOfArrival()));
        Date date1 = Calendar.getInstance().getTime();
        
        if (date1.getTime()<date.getTime()) {
            errors.add("Дата не может быть больше текущей");
        }
        } catch (Exception e) {
            errors.add("Дата введена не в формате yyyy-MM-dd");
        }
        
        if (productStock.getCriticalNorm()<=0) {
            errors.add("Критическая норма продукта не может быть нулем или меньше нуля");
        }

        return errors;
    }

}

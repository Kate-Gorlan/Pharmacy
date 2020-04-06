package pharmacy.service;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import pharmacy.common.ProductCriticalNorm;
import pharmacy.common.ProductProgress;
import pharmacy.dao.ProductDao;
import pharmacy.entity.Medicament;
import pharmacy.entity.Product;
import pharmacy.entity.ProductStock;

public class ProductService {

    private ProductDao productDao;

    public ProductDao getProductDao() {
        return productDao;
    }

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }
    
    public void decoding(Product product) throws UnsupportedEncodingException {
        String name = new String(product.getName().getBytes("iso-8859-1"), "utf-8");
        product.setName(name);
        String type = new String(product.getType().getBytes("iso-8859-1"), "utf-8");
        product.setType(type);
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
    
    public int getVolumeOfPUForThePeriod(String name, String fd, String sd){
        HashMap<String, Object> values = new HashMap<String, Object>();
        values.put("productName", name);
        values.put("firstDate", fd);
        values.put("secondDate", sd);
        return productDao.getVolumeOfPUForThePeriod(values);
    }
    
    public ArrayList<String> errorsProdProgress(String name, String fd, String sd) {
        ArrayList<String> errors = new ArrayList<String>();
        try {
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(fd);
        Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(sd);
        
        if (date1.getTime()<date.getTime()) {
            errors.add("Дата не может быть больше текущей");
        }
        } catch (Exception e) {
            errors.add("Дата введена не в формате yyyy-MM-dd");
        }

        return errors;
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
    
    public List<ProductProgress> getProductForOrderInProduction(){
        return productDao.getProductForOrderInProduction();
    }
}

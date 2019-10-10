package pharmacy.entity;

import java.math.BigDecimal;

public class ProductStock extends Entity {

    private static final long serialVersionUID = 1L;

    private Product product;
    private Integer quantity;
    private BigDecimal price;
    private String dateOfArrival;
    private Integer shelfLife;
    private Integer criticalNorm;
    
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public String getDateOfArrival() {
        return dateOfArrival;
    }
    public void setDateOfArrival(String dateOfArrival) {
        this.dateOfArrival = dateOfArrival;
    }
    public Integer getShelfLife() {
        return shelfLife;
    }
    public void setShelfLife(Integer shelfLife) {
        this.shelfLife = shelfLife;
    }
    public Integer getCriticalNorm() {
        return criticalNorm;
    }
    public void setCriticalNorm(Integer criticalNorm) {
        this.criticalNorm = criticalNorm;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }


}

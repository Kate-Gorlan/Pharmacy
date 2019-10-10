package pharmacy.entity;

import java.math.BigDecimal;

public class Ingredient extends Entity {

    private static final long serialVersionUID = 1L;
    
    private RecipeMedicament recipeMedicament;
    private Product product;
    private Integer quantity;
    private Integer timeForPreparing;
    private BigDecimal money;
    
    public RecipeMedicament getRecipeMedicament() {
        return recipeMedicament;
    }
    public void setRecipeMedicament(RecipeMedicament recipeMedicament) {
        this.recipeMedicament = recipeMedicament;
    }
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public Integer getTimeForPreparing() {
        return timeForPreparing;
    }
    public void setTimeForPreparing(Integer timeForPreparing) {
        this.timeForPreparing = timeForPreparing;
    }
    public BigDecimal getMoney() {
        return money;
    }
    public void setMoney(BigDecimal money) {
        this.money = money;
    }
    
}

package pharmacy.common;

import java.math.BigDecimal;

public class MedInfoAvailability {

    private String name;
    private int manufacturability;
    private int quantity;
    private BigDecimal price;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getManufacturability() {
        return manufacturability;
    }
    public void setManufacturability(int manufacturability) {
        this.manufacturability = manufacturability;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}

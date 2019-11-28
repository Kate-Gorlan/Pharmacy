package pharmacy.common;

import java.math.BigDecimal;

public class MedicamentInfo {

    private String medicamentType;
    private String technology;
    private int ingredient;
    private String productName;
    private int deliveryQuantity;
    private BigDecimal deliveryPrice;
    
    public String getMedicamentType() {
        return medicamentType;
    }
    public void setMedicamentType(String medicamentType) {
        this.medicamentType = medicamentType;
    }
    public String getTechnology() {
        return technology;
    }
    public void setTechnology(String technology) {
        this.technology = technology;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public int getIngredient() {
        return ingredient;
    }
    public void setIngredient(int ingredient) {
        this.ingredient = ingredient;
    }
    public int getDeliveryQuantity() {
        return deliveryQuantity;
    }
    public void setDeliveryQuantity(int deliveryQuantity) {
        this.deliveryQuantity = deliveryQuantity;
    }
    public BigDecimal getDeliveryPrice() {
        return deliveryPrice;
    }
    public void setDeliveryPrice(BigDecimal deliveryPrice) {
        this.deliveryPrice = deliveryPrice.setScale(2, BigDecimal.ROUND_HALF_EVEN);
    }    
}

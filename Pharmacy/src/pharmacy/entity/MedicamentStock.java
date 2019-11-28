package pharmacy.entity;

import java.math.BigDecimal;

public class MedicamentStock extends Entity {

    private static final long serialVersionUID = 1L;

    private Medicament medicament;
    private Integer quantity;
    private BigDecimal price;
    private String dateOfArrival;
    private Integer shelfLife;
    private Integer criticalNorm;
    
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price.setScale(2, BigDecimal.ROUND_HALF_EVEN);
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
    public Medicament getMedicament() {
        return medicament;
    }
    public void setMedicament(Medicament medicament) {
        this.medicament = medicament;
    }


}

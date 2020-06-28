package pharmacy.common;

import java.math.BigDecimal;

public class OrderCostInfo {

    private Long id;
    private BigDecimal cost;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public BigDecimal getCost() {
        return cost;
    }
    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }
    
    
}

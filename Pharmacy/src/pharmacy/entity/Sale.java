package pharmacy.entity;

import java.math.BigDecimal;

public class Sale extends Entity {

    private static final long serialVersionUID = 1L;
    
    private Order order;
    private BigDecimal cost;
    
    public Order getOrder() {
        return order;
    }
    public void setOrder(Order order) {
        this.order = order;
    }
    public BigDecimal getCost() {
        return cost;
    }
    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }


    
}

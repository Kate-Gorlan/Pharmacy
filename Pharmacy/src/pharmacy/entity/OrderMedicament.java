package pharmacy.entity;

public class OrderMedicament extends Entity {

    private static final long serialVersionUID = 1L;
    
    private Order order;
    
    private Medicament medicament;
    
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    private int quantity;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Medicament getMedicament() {
        return medicament;
    }

    public void setMedicament(Medicament medicament) {
        this.medicament = medicament;
    }
    
}

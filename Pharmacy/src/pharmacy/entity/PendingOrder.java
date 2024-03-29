package pharmacy.entity;

public class PendingOrder extends Entity {

    private static final long serialVersionUID = 1L;
    
    private Order order;
    private Employee employee;
    
    private String availabilityDate;
    private String takeStatus;
    public Order getOrder() {
        return order;
    }
    public void setOrder(Order order) {
        this.order = order;
    }
    public Employee getEmployee() {
        return employee;
    }
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getTakeStatus() {
        return takeStatus;
    }
    public void setTakeStatus(String takeStatus) {
        this.takeStatus = takeStatus;
    }
    public String getAvailabilityDate() {
        return availabilityDate;
    }
    public void setAvailabilityDate(String availabilityDate) {
        this.availabilityDate = availabilityDate;
    }

}

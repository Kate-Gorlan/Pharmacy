package pharmacy.entity;

public class Order extends Entity {

    private static final long serialVersionUID = 1L;
    
    private Employee employee;
    
    private Client client;
    
    private String date;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

}

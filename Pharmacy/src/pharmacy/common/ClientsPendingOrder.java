package pharmacy.common;

public class ClientsPendingOrder {

    private String medicamentName;
    private String orderDate;
    private String availabilityDate;
    private long id;
    private String client;
    private String clientPhone;
    
    public String getMedicamentName() {
        return medicamentName;
    }
    public void setMedicamentName(String medicamentName) {
        this.medicamentName = medicamentName;
    }
    public String getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }
    public String getAvailabilityDate() {
        return availabilityDate;
    }
    public void setAvailabilityDate(String availabilityDate) {
        this.availabilityDate = availabilityDate;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getClient() {
        return client;
    }
    public void setClient(String client) {
        this.client = client;
    }
    public String getClientPhone() {
        return clientPhone;
    }
    public void setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone;
    }
}

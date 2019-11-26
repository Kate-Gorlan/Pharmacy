package pharmacy.common;

public class OrderInProduction {

    private String medicament;
    private String orderDate;
    private String availabilityDate;
    private String manufacturer;
    
    public String getMedicament() {
        return medicament;
    }
    public void setMedicament(String medicament) {
        this.medicament = medicament;
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
    public String getManufacturer() {
        return manufacturer;
    }
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
    
}

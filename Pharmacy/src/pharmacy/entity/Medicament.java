package pharmacy.entity;

public class Medicament extends Entity {

    private static final long serialVersionUID = 1L;
    
    private String name;
    private String modeOfApplication;
    private String type;
    private int availabilityOfPrescription;
    private int manufacturability;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getModeOfApplication() {
        return modeOfApplication;
    }
    public void setModeOfApplication(String modeOfApplication) {
        this.modeOfApplication = modeOfApplication;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public int getAvailabilityOfPrescription() {
        return availabilityOfPrescription;
    }
    public void setAvailabilityOfPrescription(int availabilityOfPrescription) {
        this.availabilityOfPrescription = availabilityOfPrescription;
    }
    public int getManufacturability() {
        return manufacturability;
    }
    public void setManufacturability(int manufacturability) {
        this.manufacturability = manufacturability;
    } 

}

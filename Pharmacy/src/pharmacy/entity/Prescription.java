package pharmacy.entity;

public class Prescription extends Entity {

    private static final long serialVersionUID = 1L;
    
    private Medicament medicament;
    private Client client;
    private Doctor doctor;
    private Integer amountOfMedicine;
    private String diagnosis;
    private String signature;
    private String seal;
    
    public Medicament getMedicament() {
        return medicament;
    }
    public void setMedicament(Medicament medicament) {
        this.medicament = medicament;
    }
    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
    public Doctor getDoctor() {
        return doctor;
    }
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
    public Integer getAmountOfMedicine() {
        return amountOfMedicine;
    }
    public void setAmountOfMedicine(Integer amountOfMedicine) {
        this.amountOfMedicine = amountOfMedicine;
    }
    public String getDiagnosis() {
        return diagnosis;
    }
    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }
    public String getSignature() {
        return signature;
    }
    public void setSignature(String signature) {
        this.signature = signature;
    }
    public String getSeal() {
        return seal;
    }
    public void setSeal(String seal) {
        this.seal = seal;
    }

}

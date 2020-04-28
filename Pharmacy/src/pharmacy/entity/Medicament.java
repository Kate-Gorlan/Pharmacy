package pharmacy.entity;

public class Medicament extends Entity {

    private static final long serialVersionUID = 1L;
    
    private String name;
    private String modeOfApplication;
    private String type;
    private int availabilityOfPrescription;
    private int manufacturability;
    
    private String picture;
    private String description;
    private String indications;
    private String dosesAndMethodOfAppl;
    private String contraindications;
    private String precautions;
    private String interaction;
    private String pregnancyAndBreastfeeding;
    private String influenceTM;
    private String sideEffect;
    private String overdose;
    
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
    public String getPicture() {
        return picture;
    }
    public void setPicture(String picture) {
        this.picture = picture;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getIndications() {
        return indications;
    }
    public void setIndications(String indications) {
        this.indications = indications;
    }
    public String getDosesAndMethodOfAppl() {
        return dosesAndMethodOfAppl;
    }
    public void setDosesAndMethodOfAppl(String dosesAndMethodOfAppl) {
        this.dosesAndMethodOfAppl = dosesAndMethodOfAppl;
    }
    public String getContraindications() {
        return contraindications;
    }
    public void setContraindications(String contraindications) {
        this.contraindications = contraindications;
    }
    public String getPrecautions() {
        return precautions;
    }
    public void setPrecautions(String precautions) {
        this.precautions = precautions;
    }
    public String getInteraction() {
        return interaction;
    }
    public void setInteraction(String interaction) {
        this.interaction = interaction;
    }
    public String getPregnancyAndBreastfeeding() {
        return pregnancyAndBreastfeeding;
    }
    public void setPregnancyAndBreastfeeding(String pregnancyAndBreastfeeding) {
        this.pregnancyAndBreastfeeding = pregnancyAndBreastfeeding;
    }
    public String getInfluenceTM() {
        return influenceTM;
    }
    public void setInfluenceTM(String influenceTM) {
        this.influenceTM = influenceTM;
    }
    public String getSideEffect() {
        return sideEffect;
    }
    public void setSideEffect(String sideEffect) {
        this.sideEffect = sideEffect;
    }
    public String getOverdose() {
        return overdose;
    }
    public void setOverdose(String overdose) {
        this.overdose = overdose;
    } 

}

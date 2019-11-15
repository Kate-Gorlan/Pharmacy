package pharmacy.entity;

public class RecipeMedicament extends Entity {

    private static final long serialVersionUID = 1L;
    
    private Medicament medicament;
    private String technology;
    private int settlingTime;
    
    public Medicament getMedicament() {
        return medicament;
    }
    public void setMedicament(Medicament medicament) {
        this.medicament = medicament;
    }
    public String getTechnology() {
        return technology;
    }
    public void setTechnology(String technology) {
        this.technology = technology;
    }
    public int getSettlingTime() {
        return settlingTime;
    }
    public void setSettlingTime(int settlingTime) {
        this.settlingTime = settlingTime;
    }
    
}

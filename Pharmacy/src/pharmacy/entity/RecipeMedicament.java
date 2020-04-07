package pharmacy.entity;

import java.util.List;

import pharmacy.entity.Ingredient;

public class RecipeMedicament extends Entity {

    private static final long serialVersionUID = 1L;
    
    private Medicament medicament;
    private String technology;
    private int settlingTime;
    private int quantity;
    private List<Ingredient> ingredients;
    
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
    public List<Ingredient> getIngredients() {
        return ingredients;
    }
    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
}

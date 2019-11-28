package pharmacy.common;

import java.math.BigDecimal;

public class MedicamentIngredients {

    private long id;
    private int medicament;
    private String medicamentName;
    private String medicamentType;
    private int recipeMedicament;
    private int settlingTime;
    private String technology;
    private int ingredient;
    private int product;
    private int ingredientQuantity;
    private BigDecimal priceOfWork;
    private int timeForPreparing;
    private String productName;
    private String productType;
    private int stock;
    private BigDecimal productPrice;
    private int productQuantity;
    private int productNeedQuantity;
    private BigDecimal productNeedPrice;
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public int getMedicament() {
        return medicament;
    }
    public void setMedicament(int medicament) {
        this.medicament = medicament;
    }
    public String getMedicamentName() {
        return medicamentName;
    }
    public void setMedicamentName(String medicamentName) {
        this.medicamentName = medicamentName;
    }
    public String getMedicamentType() {
        return medicamentType;
    }
    public void setMedicamentType(String medicamentType) {
        this.medicamentType = medicamentType;
    }
    public int getRecipeMedicament() {
        return recipeMedicament;
    }
    public void setRecipeMedicament(int recipeMedicament) {
        this.recipeMedicament = recipeMedicament;
    }
    public int getSettlingTime() {
        return settlingTime;
    }
    public void setSettlingTime(int settlingTime) {
        this.settlingTime = settlingTime;
    }
    public String getTechnology() {
        return technology;
    }
    public void setTechnology(String technology) {
        this.technology = technology;
    }
    public int getIngredient() {
        return ingredient;
    }
    public void setIngredient(int ingredient) {
        this.ingredient = ingredient;
    }
    public int getProduct() {
        return product;
    }
    public void setProduct(int product) {
        this.product = product;
    }
    public int getIngredientQuantity() {
        return ingredientQuantity;
    }
    public void setIngredientQuantity(int ingredientQuantity) {
        this.ingredientQuantity = ingredientQuantity;
    }
    public BigDecimal getPriceOfWork() {
        return priceOfWork;
    }
    public void setPriceOfWork(BigDecimal priceOfWork) {
        this.priceOfWork = priceOfWork.setScale(2, BigDecimal.ROUND_HALF_EVEN);
    }
    public int getTimeForPreparing() {
        return timeForPreparing;
    }
    public void setTimeForPreparing(int timeForPreparing) {
        this.timeForPreparing = timeForPreparing;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public String getProductType() {
        return productType;
    }
    public void setProductType(String productType) {
        this.productType = productType;
    }
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
    public BigDecimal getProductPrice() {
        return productPrice;
    }
    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice.setScale(2, BigDecimal.ROUND_HALF_EVEN);
    }
    public int getProductQuantity() {
        return productQuantity;
    }
    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }
    public int getProductNeedQuantity() {
        return productNeedQuantity;
    }
    public void setProductNeedQuantity(int productNeedQuantity) {
        this.productNeedQuantity = productNeedQuantity;
    }
    public BigDecimal getProductNeedPrice() {
        return productNeedPrice;
    }
    public void setProductNeedPrice(BigDecimal productNeedPrice) {
        this.productNeedPrice = productNeedPrice.setScale(2, BigDecimal.ROUND_HALF_EVEN);
    }
}

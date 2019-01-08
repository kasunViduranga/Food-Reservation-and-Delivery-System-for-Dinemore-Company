package lk.ijse.student.dinemoreSystem.commen.dto;

public class FoodDTO extends SuperDTO {
    private String itemCode;
    private String itemName;
    private String itemDescription;
    private double prise;

    public FoodDTO() {
    }

    public FoodDTO(String itemCode, String itemName, String itemDescription, double prise) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.prise = prise;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public double getPrise() {
        return prise;
    }

    public void setPrise(double prise) {
        this.prise = prise;
    }
}

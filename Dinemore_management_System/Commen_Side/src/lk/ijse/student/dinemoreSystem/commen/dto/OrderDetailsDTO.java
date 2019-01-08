package lk.ijse.student.dinemoreSystem.commen.dto;

public class OrderDetailsDTO extends SuperDTO {
    private String orderID;
    private String itemName;
    private int qty;

    public OrderDetailsDTO() {
    }

    public OrderDetailsDTO(String orderID, String itemName, int qty) {
        this.orderID = orderID;
        this.itemName = itemName;
        this.qty = qty;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}

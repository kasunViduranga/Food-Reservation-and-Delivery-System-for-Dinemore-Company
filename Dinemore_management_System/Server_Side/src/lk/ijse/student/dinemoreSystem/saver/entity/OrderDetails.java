package lk.ijse.student.dinemoreSystem.saver.entity;

public class OrderDetails {
    private String orderID;
    private String itemName;
    private int qty;

    public OrderDetails() {
    }

    public OrderDetails(String orderID, String itemName, int qty) {
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

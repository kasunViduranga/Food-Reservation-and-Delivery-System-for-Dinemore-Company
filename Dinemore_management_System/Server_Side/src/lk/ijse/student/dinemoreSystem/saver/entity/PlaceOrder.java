package lk.ijse.student.dinemoreSystem.saver.entity;

public class PlaceOrder {
    private String orederID;
    private String customerID;
    private String orderDate;
    private int orderQty;
    private double unitPrice;
    private String states;

    public PlaceOrder() {
    }

    public PlaceOrder(String orederID, String customerID, String orderDate, int orderQty, double unitPrice,String states) {
        this.orederID = orederID;
        this.customerID = customerID;
        this.orderDate = orderDate;
        this.orderQty = orderQty;
        this.unitPrice = unitPrice;
        this.states=states;
    }

    public String getOrederID() {
        return orederID;
    }

    public void setOrederID(String orederID) {
        this.orederID = orederID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public int getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(int orderQty) {
        this.orderQty = orderQty;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getStates() {
        return states;
    }

    public void setStates(String states) {
        this.states = states;
    }
}

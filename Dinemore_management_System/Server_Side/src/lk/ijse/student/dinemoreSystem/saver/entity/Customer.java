package lk.ijse.student.dinemoreSystem.saver.entity;

public class Customer {

    private String cusID;
    private String cusName;
    private String cusAddress;
    private String cusNIC;
    private int cusTell;

    public Customer() {
    }

    public Customer(String cusID, String cusName, String cusAddress, String cusNIC, int cusTell) {
        this.cusID = cusID;
        this.cusName = cusName;
        this.cusAddress = cusAddress;
        this.cusNIC = cusNIC;
        this.cusTell = cusTell;
    }

    public String getCusID() {
        return cusID;
    }

    public void setCusID(String cusID) {
        this.cusID = cusID;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getCusAddress() {
        return cusAddress;
    }

    public void setCusAddress(String cusAddress) {
        this.cusAddress = cusAddress;
    }

    public String getCusNIC() {
        return cusNIC;
    }

    public void setCusNIC(String cusNIC) {
        this.cusNIC = cusNIC;
    }

    public int getCusTell() {
        return cusTell;
    }

    public void setCusTell(int cusTell) {
        this.cusTell = cusTell;
    }
}

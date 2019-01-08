package lk.ijse.student.dinemoreSystem.saver.entity;

public class Deliver {

    private String deID;
    private String deFName;
    private String deLName;
    private String deAddress;
    private String deNIC;
    private int deCoNumber;

    public Deliver() {
    }

    public Deliver(String deID, String deFName, String deLName, String deAddress, String deNIC, int deCoNumber) {
        this.deID = deID;
        this.deFName = deFName;
        this.deLName = deLName;
        this.deAddress = deAddress;
        this.deNIC = deNIC;
        this.deCoNumber = deCoNumber;
    }

    public String getDeID() {
        return deID;
    }

    public void setDeID(String deID) {
        this.deID = deID;
    }

    public String getDeFName() {
        return deFName;
    }

    public void setDeFName(String deFName) {
        this.deFName = deFName;
    }

    public String getDeLName() {
        return deLName;
    }

    public void setDeLName(String deLName) {
        this.deLName = deLName;
    }

    public String getDeAddress() {
        return deAddress;
    }

    public void setDeAddress(String deAddress) {
        this.deAddress = deAddress;
    }

    public String getDeNIC() {
        return deNIC;
    }

    public void setDeNIC(String deNIC) {
        this.deNIC = deNIC;
    }

    public int getDeCoNumber() {
        return deCoNumber;
    }

    public void setDeCoNumber(int deCoNumber) {
        this.deCoNumber = deCoNumber;
    }
}

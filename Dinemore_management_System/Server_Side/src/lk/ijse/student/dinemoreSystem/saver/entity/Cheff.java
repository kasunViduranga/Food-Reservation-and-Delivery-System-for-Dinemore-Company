package lk.ijse.student.dinemoreSystem.saver.entity;

public class Cheff {
    private String chefID;
    private String chefF_Name;
    private String chefL_Name;
    private String chefAddress;
    private String chef_NicNO;
    private int chefTel;

    public Cheff() {
    }

    public Cheff(String chefID, String chefF_Name, String chefL_Name, String chefAddress, String chef_NicNO, int chefTel) {

        this.chefID = chefID;
        this.chefF_Name = chefF_Name;
        this.chefL_Name = chefL_Name;
        this.chefAddress = chefAddress;
        this.chef_NicNO = chef_NicNO;
        this.chefTel = chefTel;
    }

    public String getChefID() {
        return chefID;
    }

    public void setChefID(String chefID) {
        this.chefID = chefID;
    }

    public String getChefF_Name() {
        return chefF_Name;
    }

    public void setChefF_Name(String chefF_Name) {
        this.chefF_Name = chefF_Name;
    }

    public String getChefL_Name() {
        return chefL_Name;
    }

    public void setChefL_Name(String chefL_Name) {
        this.chefL_Name = chefL_Name;
    }

    public String getChefAddress() {
        return chefAddress;
    }

    public void setChefAddress(String chefAddress) {
        this.chefAddress = chefAddress;
    }

    public String getChef_NicNO() {
        return chef_NicNO;
    }

    public void setChef_NicNO(String chef_NicNO) {
        this.chef_NicNO = chef_NicNO;
    }

    public int getChefTel() {
        return chefTel;
    }

    public void setChefTel(int chefTel) {
        this.chefTel = chefTel;
    }
}

package lk.ijse.student.dinemoreSystem.saver.entity;

public class Reception {

    private String receptionID;
    private String receptionF_Name;
    private String receptionL_Name;
    private String receptionAddress;
    private String reception_NicNO;
    private int receptionTel;

    public Reception() {
    }

    public Reception(String receptionID, String receptionF_Name, String receptionL_Name, String receptionAddress, String reception_NicNO, int receptionTel) {
        this.receptionID = receptionID;
        this.receptionF_Name = receptionF_Name;
        this.receptionL_Name = receptionL_Name;
        this.receptionAddress = receptionAddress;
        this.reception_NicNO = reception_NicNO;
        this.receptionTel = receptionTel;
    }

    public String getReceptionID() {
        return receptionID;
    }

    public void setReceptionID(String receptionID) {
        this.receptionID = receptionID;
    }

    public String getReceptionF_Name() {
        return receptionF_Name;
    }

    public void setReceptionF_Name(String receptionF_Name) {
        this.receptionF_Name = receptionF_Name;
    }

    public String getReceptionL_Name() {
        return receptionL_Name;
    }

    public void setReceptionL_Name(String receptionL_Name) {
        this.receptionL_Name = receptionL_Name;
    }

    public String getReceptionAddress() {
        return receptionAddress;
    }

    public void setReceptionAddress(String receptionAddress) {
        this.receptionAddress = receptionAddress;
    }

    public String getReception_NicNO() {
        return reception_NicNO;
    }

    public void setReception_NicNO(String reception_NicNO) {
        this.reception_NicNO = reception_NicNO;
    }

    public int getReceptionTel() {
        return receptionTel;
    }

    public void setReceptionTel(int receptionTel) {
        this.receptionTel = receptionTel;
    }
}

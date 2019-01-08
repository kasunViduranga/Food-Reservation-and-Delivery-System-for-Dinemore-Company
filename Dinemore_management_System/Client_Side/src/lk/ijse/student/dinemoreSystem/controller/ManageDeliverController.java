package lk.ijse.student.dinemoreSystem.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import lk.ijse.student.dinemoreSystem.commen.dto.DeliverDTO;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class ManageDeliverController implements Initializable {

    @FXML
    private JFXTextField txtDeID;

    @FXML
    private JFXTextField txtFName;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXTextField txtConNumber;

    @FXML
    private JFXTextField txtNICNum;

    @FXML
    private JFXTextField txtLName;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    public void addDeliver(javafx.event.ActionEvent actionEvent) {

        String deID=txtDeID.getText();
        String deFName=txtFName.getText();
        String deLName=txtLName.getText();
        String deAddress=txtAddress.getText();
        String deNIC=txtNICNum.getText();
        int deCoNumber=Integer.parseInt(txtConNumber.getText());

        DeliverDTO deliverDTO=new DeliverDTO(deID,deFName,deLName,deAddress,deNIC,deCoNumber);


    }

    @FXML
    public void updateDeliver(javafx.event.ActionEvent actionEvent) {
    }

    @FXML
    public void deleteDeliver(javafx.event.ActionEvent actionEvent) {
    }
}

package lk.ijse.student.dinemoreSystem.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.student.dinemoreSystem.commen.cm_custome.ChefService;
import lk.ijse.student.dinemoreSystem.commen.cm_service.ServiceFactory;
import lk.ijse.student.dinemoreSystem.commen.dto.ChefDTO;
import lk.ijse.student.dinemoreSystem.proxy.ProxyHandler;
import lk.ijse.student.dinemoreSystem.saver.resourse.DBConnection;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.util.*;

public class ManageCheffController implements Initializable {

    @FXML
    private JFXTextField txtChID;

    @FXML
    private JFXTextField txtF_Name;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXTextField txtCNumber;

    @FXML
    private JFXTextField txtNIC;

    @FXML
    private JFXTextField txtL_Name;

    @FXML
    private TableView<ChefDTO> chefTable;

    private ChefService chefService;



    @Override
    public void initialize(URL location, ResourceBundle resources)  {

        try {
            chefService= (ChefService) ProxyHandler.getInstance().getService(ServiceFactory.serviceType.CHEFF);
            getAllChef();
        } catch (Exception e) {
            e.printStackTrace();
        }
//        new Timer().schedule(new TimerTask() {
//            @Override
//            public void run() {
//                getAllChef();
//            }
//        },new Date(),5000);
//        getAllChef();
    }

    @FXML
    public void addChef(javafx.event.ActionEvent actionEvent) throws Exception {
        String id=txtChID.getText();
        String fName=txtF_Name.getText();
        String Lname=txtL_Name.getText();
        String address=txtAddress.getText();
        String  nic=txtNIC.getText();
        int tell=Integer.parseInt(txtCNumber.getText());

        ChefDTO chefDTO=new ChefDTO(id,fName,Lname,address,nic,tell);

        boolean customer = chefService.addChef(chefDTO);
        if (customer){
            Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Added",ButtonType.OK);
            alert.showAndWait();
        }else {
            Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Added Not Sucsess Full",ButtonType.NO);
            alert.showAndWait();
        }

    }

    @FXML
    public void updateChef(javafx.event.ActionEvent actionEvent) throws JRException {

    }

    @FXML
    public void deleteChef(javafx.event.ActionEvent actionEvent) throws Exception {
        String chefID=txtChID.getText();
        boolean isDelete=chefService.DeleteChef(chefID);

        if (isDelete){
            Alert alert=new Alert(Alert.AlertType.INFORMATION,"Delete Sucsess..!",ButtonType.OK);
            alert.showAndWait();
        }else {
            Alert alert=new Alert(Alert.AlertType.INFORMATION,"Delete Not Sucsess..!",ButtonType.OK);
            alert.showAndWait();
        }
    }

    private void getAllChef(){
        chefTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("chefID"));
        chefTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("chefF_Name"));
        chefTable.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("chefL_Name"));
        chefTable.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("chefAddress"));
        chefTable.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("chef_NicNO"));
        chefTable.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("chefTel"));

        try {
            chefTable.setItems(FXCollections.observableArrayList(chefService.getAllChef()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

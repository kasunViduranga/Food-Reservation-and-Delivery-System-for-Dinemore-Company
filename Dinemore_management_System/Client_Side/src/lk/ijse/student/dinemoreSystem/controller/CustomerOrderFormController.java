package lk.ijse.student.dinemoreSystem.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Duration;
import lk.ijse.student.dinemoreSystem.commen.cm_custome.CustomerService;
import lk.ijse.student.dinemoreSystem.commen.cm_custome.FoodService;
import lk.ijse.student.dinemoreSystem.commen.cm_service.ServiceFactory;
import lk.ijse.student.dinemoreSystem.commen.dto.*;
import lk.ijse.student.dinemoreSystem.proxy.ProxyHandler;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class CustomerOrderFormController implements Initializable {

    @FXML
    private JFXTextField txtCusID;

    @FXML
    private JFXTextField txtCusAddress;

    @FXML
    private JFXTextField txtCusNIC;

    @FXML
    private JFXTextField txtCusTell;

    @FXML
    private JFXTextField txtCusName;

    @FXML
    private JFXComboBox<String> cmbFoodID;

    @FXML
    private JFXTextField txtfoodName;

    @FXML
    private JFXTextField txtFoodDescrip;

    @FXML
    private JFXTextField txtFoodQTY;

    @FXML
    private JFXTextField txtFoodUnitePrice;

    @FXML
    private JFXTextField txtOrderID;

    @FXML
    private JFXTextField txtOrderAllQTY;

    @FXML
    private JFXTextField txtOrderDate;

    @FXML
    private JFXTextField txtTotal;

    @FXML
    private TableView<OrderDetailsDTO> tblOrderDetails;

    @FXML
    private TableView<?> tblPlaceOrder;
    private CustomerService customerService;
    private FoodService foodService=null;

    private ArrayList<FoodDTO> dtos=new ArrayList<>();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            customerService= (CustomerService) ProxyHandler.getInstance().getService(ServiceFactory.serviceType.CUSTOMER);
            foodService= (FoodService) ProxyHandler.getInstance().getService(ServiceFactory.serviceType.FOOD);
            loadCombo();
            comboEv();
            txtTotal.setText("0");
            txtOrderAllQTY.setText("0");
            txtFoodQTY.setText("0");
            txtFoodUnitePrice.setText("0");
            getAllOrderDetails();
            setDAteTime();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void addCusOrder(javafx.event.ActionEvent actionEvent) throws Exception {

        String cusID=txtCusID.getText();
        String cusName=txtCusName.getText();
        String cusAddress=txtCusAddress.getText();
        String cusNic=txtCusNIC.getText();
        int cusTell=Integer.parseInt(txtCusTell.getText());

        CustomerDTO customerDTO=new CustomerDTO(cusID,cusName,cusAddress,cusNic,cusTell);

        String itemCode= (String) cmbFoodID.getValue();
        String itemName=txtfoodName.getText();
        String ItemDesc=txtFoodDescrip.getText();
        int itemQTY=Integer.parseInt(txtFoodQTY.getText());
        Double unitePrice=Double.parseDouble(txtFoodUnitePrice.getText());

        String orederID=txtOrderID.getText();
        String orderDate=txtOrderDate.getText();
        Double total=Double.parseDouble(txtTotal.getText());
        String states="Pending";

        PlaceOrderDTO placeOrderDTO=new PlaceOrderDTO(orederID,cusID,orderDate,itemQTY,total,states);
        CommonDTO dto=new CommonDTO(customerDTO,placeOrderDTO);
        boolean Isadd = customerService.saveCustomer(dto);
        if(Isadd){
            Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Added Sucsess",ButtonType.YES);
            alert.showAndWait();
        }else {
            Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Added Not Sucsess",ButtonType.YES);
            alert.showAndWait();
        }

    }

    void loadCombo() throws Exception {
        dtos=foodService.getAllFood();
        ObservableList<String> ids=FXCollections.observableArrayList();
        for (FoodDTO dto:dtos){
            ids.add(dto.getItemCode());
        }
        cmbFoodID.setItems(ids);
    }

    private void comboEv(){
        cmbFoodID.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                String id=cmbFoodID.getValue();
                FoodDTO foodDTO=null;
                try {
                    foodDTO=foodService.searchFood(id);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                if (foodDTO!=null){
                    txtfoodName.setText(foodDTO.getItemName());
                    txtFoodDescrip.setText(foodDTO.getItemDescription());
                    txtFoodUnitePrice.setText(Double.toString(foodDTO.getPrise()));
                }
            }
        });
    }

    void setTotal(){
        double total=Double.parseDouble(txtFoodUnitePrice.getText())+Double.parseDouble(txtTotal.getText());
        int qty=Integer.parseInt(txtFoodQTY.getText())+Integer.parseInt(txtOrderAllQTY.getText());
        txtTotal.setText(Double.toString(total));
        txtOrderAllQTY.setText(Integer.toString(qty));
    }

    @FXML
    public void addFood(javafx.event.ActionEvent actionEvent) throws Exception {
        String orderID=txtOrderID.getText();
        String foodName=txtfoodName.getText();
        int qty=Integer.parseInt(txtFoodQTY.getText());

        OrderDetailsDTO dto=new OrderDetailsDTO(orderID,foodName,qty);
        boolean add=foodService.addFood(dto);

        if(add){
            Alert alert=new Alert(Alert.AlertType.INFORMATION,"Added Sucsess", ButtonType.OK);
            alert.showAndWait();
        }else {
            Alert alert=new Alert(Alert.AlertType.INFORMATION,"Added not Sucsess",ButtonType.OK);
            alert.showAndWait();
        }


        setTotal();
        getAllOrderDetails();
    }

    void getAllOrderDetails() {
        tblOrderDetails.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("orederID"));
        tblOrderDetails.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("itemName"));
        tblOrderDetails.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("qty"));
        try {
            tblOrderDetails.setItems(FXCollections.observableArrayList(foodService.getAllOrderDetails()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setDAteTime(){
        Timeline timeLine = new Timeline(new KeyFrame(Duration.seconds(0), new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                txtOrderDate.setText(new SimpleDateFormat("YYYY-MM-dd").format(new Date()));
            }
        }),new KeyFrame(Duration.seconds(1)));
        timeLine.setCycleCount(Animation.INDEFINITE);
        timeLine.play();
    }
}

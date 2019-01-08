package lk.ijse.student.dinemoreSystem.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.student.dinemoreSystem.commen.cm_custome.PlaceOrderService;
import lk.ijse.student.dinemoreSystem.commen.cm_service.ServiceFactory;
import lk.ijse.student.dinemoreSystem.commen.dto.PlaceOrderDTO;
import lk.ijse.student.dinemoreSystem.proxy.ProxyHandler;

import java.net.URL;
import java.util.ResourceBundle;

public class CustomerOrderDeliverController implements Initializable {

    @FXML
    private TableView<PlaceOrderDTO> tblPlaceOrder;

    @FXML
    private JFXTextField txtCusID;

    @FXML
    private JFXTextField txtOrderID;

    @FXML
    private JFXTextField txtOrderAllQTY;

    @FXML
    private JFXTextField txtOrderDate;

    @FXML
    private JFXTextField txtTotal;

    @FXML
    private JFXTextField txtCusAddress;

    @FXML
    private JFXTextField txtCusNIC;

    @FXML
    private JFXTextField txtCusTell;

    @FXML
    private JFXTextField txtCusName;

    private PlaceOrderService placeOrderService;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            placeOrderService= (PlaceOrderService) ProxyHandler.getInstance().getService(ServiceFactory.serviceType.PLACEORDER);
        } catch (Exception e) {
            e.printStackTrace();
        }
        getAllOrder();
    }

    void getAllOrder(){
        tblPlaceOrder.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("orederID"));
        tblPlaceOrder.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("customerID"));
        tblPlaceOrder.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("orderDate"));
        tblPlaceOrder.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("orderQty"));
        tblPlaceOrder.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        tblPlaceOrder.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("states"));

        try {
            tblPlaceOrder.setItems(FXCollections.observableArrayList(placeOrderService.getAllOrderToDeliver()));
            loadTableToTXT();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadTableToTXT (){

        tblPlaceOrder.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends PlaceOrderDTO> observable, PlaceOrderDTO oldValue, PlaceOrderDTO newValue) -> {
            PlaceOrderDTO values= observable.getValue();

            txtCusID.setText(values.getCustomerID());
            txtOrderID.setText(values.getOrederID());
            txtOrderDate.setText(values.getOrderDate());
            txtOrderAllQTY.setText(Integer.toString(values.getOrderQty()));
            txtTotal.setText(Double.toString(values.getUnitPrice()));

            updateStatus();

        });
    }

    void updateStatus(){
        String orderid=txtOrderID.getText();
        String cusID=txtCusID.getText();
        String date=txtOrderDate.getText();
        int qty=Integer.parseInt(txtOrderAllQTY.getText());
        double total=Double.parseDouble(txtTotal.getText());
        String status="Delivering";

        PlaceOrderDTO dto=new PlaceOrderDTO(orderid,cusID,date,qty,total,status);
        try {
            boolean update=placeOrderService.placeOrderUpdate(dto);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void refresh(ActionEvent actionEvent) {
        getAllOrder();
    }

    @FXML
    public void orderSucses(ActionEvent actionEvent) {
        String orderid=txtOrderID.getText();
        String cusID=txtCusID.getText();
        String date=txtOrderDate.getText();
        int qty=Integer.parseInt(txtOrderAllQTY.getText());
        double total=Double.parseDouble(txtTotal.getText());
        String status="payed";

        PlaceOrderDTO dto=new PlaceOrderDTO(orderid,cusID,date,qty,total,status);
        try {
            boolean update=placeOrderService.placeOrderUpdate(dto);
        } catch (Exception e) {
            e.printStackTrace();
        }

        getAllOrder();
    }
}

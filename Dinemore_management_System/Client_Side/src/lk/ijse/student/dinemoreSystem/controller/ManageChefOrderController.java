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
import lk.ijse.student.dinemoreSystem.commen.dto.OrderDetailsDTO;
import lk.ijse.student.dinemoreSystem.commen.dto.PlaceOrderDTO;
import lk.ijse.student.dinemoreSystem.proxy.ProxyHandler;

import java.net.URL;
import java.util.ResourceBundle;

public class ManageChefOrderController implements Initializable {
    @FXML
    private TableView<PlaceOrderDTO> tblPlaceOrder;

    @FXML
    private TableView<OrderDetailsDTO> tblOrderDetails;

    private PlaceOrderService placeOrderService;

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            placeOrderService= (PlaceOrderService) ProxyHandler.getInstance().getService(ServiceFactory.serviceType.PLACEORDER);
            loadTableToTXT();
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
            tblPlaceOrder.setItems(FXCollections.observableArrayList(placeOrderService.getAllPlaceOrder()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void searchAllOrderDetails(){
        String orderid=txtOrderID.getText();

        tblOrderDetails.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("orderID"));
        tblOrderDetails.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("itemName"));
        tblOrderDetails.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("qty"));

        try {
            tblOrderDetails.setItems(FXCollections.observableArrayList(placeOrderService.getAllOrderDetails(orderid)));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void refreshTable(ActionEvent actionEvent) {
        txtCusID.clear();
        txtOrderID.clear();
        txtOrderDate.clear();
        txtOrderAllQTY.clear();
        txtTotal.clear();
        getAllOrder();
    }

    @FXML
    public void compliteOrder(ActionEvent actionEvent) {
        String orderid=txtOrderID.getText();
        String cusID=txtCusID.getText();
        String date=txtOrderDate.getText();
        int qty=Integer.parseInt(txtOrderAllQTY.getText());
        double total=Double.parseDouble(txtTotal.getText());
        String status="Cooked";

        PlaceOrderDTO dto=new PlaceOrderDTO(orderid,cusID,date,qty,total,status);
        try {
            boolean update=placeOrderService.placeOrderUpdate(dto);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadTableToTXT () throws Exception{

        tblPlaceOrder.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends PlaceOrderDTO> observable, PlaceOrderDTO oldValue, PlaceOrderDTO newValue) -> {
            PlaceOrderDTO values= observable.getValue();

            txtCusID.setText(values.getCustomerID());
            txtOrderID.setText(values.getOrederID());
            txtOrderDate.setText(values.getOrderDate());
            txtOrderAllQTY.setText(Integer.toString(values.getOrderQty()));
            txtTotal.setText(Double.toString(values.getUnitPrice()));


            ///////////update status///////////////

            updateStatus();
            searchAllOrderDetails();
        });
    }

    void updateStatus(){
        String orderid=txtOrderID.getText();
        String cusID=txtCusID.getText();
        String date=txtOrderDate.getText();
        int qty=Integer.parseInt(txtOrderAllQTY.getText());
        double total=Double.parseDouble(txtTotal.getText());
        String status="Cooking";

        PlaceOrderDTO dto=new PlaceOrderDTO(orderid,cusID,date,qty,total,status);
        try {
            boolean update=placeOrderService.placeOrderUpdate(dto);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

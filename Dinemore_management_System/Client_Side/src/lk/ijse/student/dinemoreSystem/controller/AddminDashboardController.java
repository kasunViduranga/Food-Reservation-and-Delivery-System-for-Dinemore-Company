package lk.ijse.student.dinemoreSystem.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;

public class AddminDashboardController implements Initializable {


    @FXML
    private JFXTextField lblname;

    @FXML
    private JFXTextField lblTime;

    @FXML
    private JFXTextField lblDate;

    @FXML
    private AnchorPane mainPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setDAteTime();

        AnchorPane an= null;
        try {
            an = FXMLLoader.load(this.getClass().getResource("/lk/ijse/student/dinemoreSystem/view/Homepage.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        mainPane.getChildren().add(an);
    }

    @FXML
    public void manageAdmin(javafx.event.ActionEvent actionEvent) throws IOException {
        AnchorPane an=FXMLLoader.load(this.getClass().getResource("/lk/ijse/student/dinemoreSystem/view/AddminView/ManageAddmin.fxml"));
        mainPane.getChildren().add(an);
    }
    @FXML
    public void manageCheff(javafx.event.ActionEvent actionEvent) throws IOException {
        AnchorPane an=FXMLLoader.load(this.getClass().getResource("/lk/ijse/student/dinemoreSystem/view/AddminView/ManageCheff.fxml"));
        mainPane.getChildren().add(an);
    }
    @FXML
    public void manageDeliver(javafx.event.ActionEvent actionEvent) throws IOException {
        AnchorPane an=FXMLLoader.load(this.getClass().getResource("/lk/ijse/student/dinemoreSystem/view/AddminView/ManageDeliver.fxml"));
        mainPane.getChildren().add(an);
    }
    @FXML
    public void manageReception(javafx.event.ActionEvent actionEvent) throws IOException {
        AnchorPane an=FXMLLoader.load(this.getClass().getResource("/lk/ijse/student/dinemoreSystem/view/AddminView/ManageReception.fxml"));
        mainPane.getChildren().add(an);
    }

    @FXML
    void close(MouseEvent event) {
        Stage stage  = (Stage) mainPane.getScene().getWindow();
        Alert a=new Alert(Alert.AlertType.INFORMATION, "Are you Sure, do you want Exite on Dinemore Management System ?", ButtonType.YES,ButtonType.NO);
        Optional<ButtonType> result=a.showAndWait();
        if (result.get()==ButtonType.YES){
            stage.close();
        }else{
            a.close();
        }
    }

    private void setDAteTime(){
        Timeline timeLine = new Timeline(new KeyFrame(Duration.seconds(0), new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                lblDate.setText(new SimpleDateFormat("YYYY-MM-dd").format(new Date()));
                lblTime.setText(new SimpleDateFormat("hh:mm:ss a").format(new Date()));
            }
        }),new KeyFrame(Duration.seconds(1)));
        timeLine.setCycleCount(Animation.INDEFINITE);
        timeLine.play();
    }


    @FXML
    public void manageReport(ActionEvent actionEvent) throws IOException {
        AnchorPane an=FXMLLoader.load(this.getClass().getResource("/lk/ijse/student/dinemoreSystem/view/AddminView/ReportPage.fxml"));
        mainPane.getChildren().add(an);
    }
}

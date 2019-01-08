package lk.ijse.student.dinemoreSystem.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import lk.ijse.student.dinemoreSystem.saver.resourse.DBConnection;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.util.HashMap;
import java.util.ResourceBundle;

public class ReportPageController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    public void customerReport(ActionEvent actionEvent) throws JRException {
        InputStream is = this.getClass().getResourceAsStream("/lk/ijse/student/dinemoreSystem/report/customers.jasper");
        HashMap map = new HashMap();
        Connection connection=DBConnection.getInstance().getConnection();
        JasperPrint fillReport = JasperFillManager.fillReport(is, map, connection);
        JasperViewer.viewReport(fillReport, false);
    }

    @FXML
    public void foodDetailReport(ActionEvent actionEvent) throws JRException {
        InputStream is = this.getClass().getResourceAsStream("/lk/ijse/student/dinemoreSystem/report/FoodReport.jasper");
        HashMap map = new HashMap();
        Connection connection=DBConnection.getInstance().getConnection();
        JasperPrint fillReport = JasperFillManager.fillReport(is, map, connection);
        JasperViewer.viewReport(fillReport, false);
    }
}

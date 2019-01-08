package lk.ijse.student.dinemoreSystem.saver.daoLayer.impl;

import lk.ijse.student.dinemoreSystem.saver.daoLayer.custom.CustomerDAO;
import lk.ijse.student.dinemoreSystem.saver.entity.Customer;
import lk.ijse.student.dinemoreSystem.saver.resourse.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public boolean seveTransectionCustomer(Customer entity) throws Exception {
        String sql="Insert into customer Values(?,?,?,?,?)";
        Connection connection=DBConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1,entity.getCusID());
        pstm.setObject(2,entity.getCusName());
        pstm.setObject(3,entity.getCusAddress());
        pstm.setObject(4,entity.getCusNIC());
        pstm.setObject(5,entity.getCusTell());

        return pstm.executeUpdate() > 0;
    }

    @Override
    public void setConnection(Connection connection) throws Exception {

    }
}

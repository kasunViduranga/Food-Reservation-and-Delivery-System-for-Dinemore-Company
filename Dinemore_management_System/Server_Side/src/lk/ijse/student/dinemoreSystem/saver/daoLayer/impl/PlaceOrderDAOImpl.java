package lk.ijse.student.dinemoreSystem.saver.daoLayer.impl;

import lk.ijse.student.dinemoreSystem.saver.daoLayer.custom.PlaceOrderDAO;
import lk.ijse.student.dinemoreSystem.saver.daoLayer.dao.CrudUtil;
import lk.ijse.student.dinemoreSystem.saver.entity.OrderDetails;
import lk.ijse.student.dinemoreSystem.saver.entity.PlaceOrder;
import lk.ijse.student.dinemoreSystem.saver.resourse.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PlaceOrderDAOImpl implements PlaceOrderDAO {
  //  private PlaceOrderDAO placeOrderDAO;

    private Connection connection;
    public PlaceOrderDAOImpl() {
      //  placeOrderDAO= (PlaceOrderDAO) DAOFactory.getInstance().getDAO(DAOFactory.BOTypes.PLACEORDER);
    }

    @Override
    public void setConnection(Connection connection) throws Exception {
        this.connection=connection;
    }

    @Override
    public boolean savePlaceOrder(PlaceOrder entity) throws Exception {
        String sql="Insert into PlaceOrder values(?,?,?,?,?,?)";
        Connection connection=DBConnection.getInstance().getConnection();
        //placeOrderDAO.setConnection(connection);
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1,entity.getOrederID());
        pstm.setObject(2,entity.getCustomerID());
        pstm.setObject(3,entity.getOrderDate());
        pstm.setObject(4,entity.getOrderQty());
        pstm.setObject(5,entity.getOrderQty());
        pstm.setObject(6,entity.getStates());

        return pstm.executeUpdate()>0;

    }

    @Override
    public ArrayList<PlaceOrder> getAllPlaceOrder() throws Exception {
        String status="pending";
        String sql="select *from placeorder where states="+"'"+status+"'";
        ArrayList<PlaceOrder> orders=new ArrayList<>();
        ResultSet set=CrudUtil.executeQuery(sql);

        while (set.next()){
            orders.add(new PlaceOrder(set.getString(1),set.getString(2),set.getString(3),set.getInt(4),set.getDouble(5),set.getString(6)));
        }
        return orders;
    }

    @Override
    public ArrayList<OrderDetails> getAllOrderDetails(String id) throws Exception {
        String oID=id;
        String sql="select *from OrderDetails where orederID="+"'"+oID+"'";
        ArrayList<OrderDetails> orderDetails=new ArrayList<>();
        ResultSet set=CrudUtil.executeQuery(sql);

        while (set.next()){
            orderDetails.add(new OrderDetails(set.getString(1),set.getString(2),set.getInt(3)));
        }
        return orderDetails;
    }

    @Override
    public ArrayList<PlaceOrder> getAllOrderToDeliver() throws Exception {
        String status="Cooked";
        String sql="select *from placeorder where states="+"'"+status+"'";
        ArrayList<PlaceOrder> orders=new ArrayList<>();
        ResultSet set=CrudUtil.executeQuery(sql);

        while (set.next()){
            orders.add(new PlaceOrder(set.getString(1),set.getString(2),set.getString(3),set.getInt(4),set.getDouble(5),set.getString(6)));
        }
        return orders;
    }

    @Override
    public boolean placeOrderUpdate(PlaceOrder entity) throws Exception {
        String sql="Update PlaceOrder set customerID=?,orderDate=?,orderQty=?,unitPrice=?,states=? where orederID=?";
        Connection connection=DBConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1,entity.getCustomerID());
        pstm.setObject(2,entity.getOrderDate());
        pstm.setObject(3,entity.getOrderQty());
        pstm.setObject(4,entity.getUnitPrice());
        pstm.setObject(5,entity.getStates());
        pstm.setObject(6,entity.getOrederID());

        return pstm.executeUpdate()>0;

    }


}

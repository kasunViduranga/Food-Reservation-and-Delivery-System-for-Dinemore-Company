package lk.ijse.student.dinemoreSystem.saver.daoLayer.impl;

import lk.ijse.student.dinemoreSystem.saver.daoLayer.custom.FoodDAO;
import lk.ijse.student.dinemoreSystem.saver.daoLayer.dao.CrudUtil;
import lk.ijse.student.dinemoreSystem.saver.entity.Food;
import lk.ijse.student.dinemoreSystem.saver.entity.OrderDetails;
import lk.ijse.student.dinemoreSystem.saver.resourse.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class FoodDAOImpl implements FoodDAO {
    private Connection connection;

    @Override
    public boolean AddFood(OrderDetails orderDetails) throws Exception {
        String sql="insert into OrderDetails values (?,?,?)";
        PreparedStatement pstm=connection.prepareStatement(sql);
        pstm.setObject(1,orderDetails.getOrderID());
        pstm.setObject(2,orderDetails.getItemName());
        pstm.setObject(3,orderDetails.getQty());

        return  pstm.executeUpdate()>0;
    }

    @Override
    public boolean deleteFood(String id) throws Exception {
        return false;
    }

    @Override
    public ArrayList<Food> getAllFood() throws Exception {
        ArrayList<Food> list=new ArrayList<>();
        ResultSet set=CrudUtil.executeQuery("select * from food");
        while (set.next()){
            list.add(new Food(set.getString(1),set.getString(2),set.getString(3),set.getDouble(4)));

        }
        return list;
    }

    @Override
    public Food SearchFood(String id) throws Exception {
        String sql="select *from food where itemCode=?";
        Connection connection=DBConnection.getInstance().getConnection();
        PreparedStatement pstm=connection.prepareStatement(sql);
        pstm.setObject(1,id);
        ResultSet set=pstm.executeQuery();
        Food food=null;
        while (set.next()){
            food=new Food(set.getString(1),set.getString(2),set.getString(3),set.getDouble(4));

        }
        return food;
    }

    @Override
    public ArrayList<OrderDetails> getAllOrderDetails() throws Exception {
        Connection connection=DBConnection.getInstance().getConnection();
        ResultSet set=CrudUtil.executeQuery("select * from OrderDetails");
        ArrayList<OrderDetails> list=new ArrayList<>();
        while(set.next()){
            list.add(new OrderDetails(set.getString(1),set.getString(2),set.getInt(3)));

        }
        return list;
    }

    @Override
    public void setConnection(Connection connection) throws Exception {
        this.connection=connection;
    }
}

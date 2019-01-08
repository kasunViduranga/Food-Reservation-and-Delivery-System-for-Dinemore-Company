package lk.ijse.student.dinemoreSystem.saver.daoLayer.impl;

import lk.ijse.student.dinemoreSystem.saver.daoLayer.custom.ChefDAO;
import lk.ijse.student.dinemoreSystem.saver.daoLayer.dao.CrudUtil;
import lk.ijse.student.dinemoreSystem.saver.entity.Cheff;
import lk.ijse.student.dinemoreSystem.saver.resourse.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ChefDAOImpl implements ChefDAO {
    private Connection connection;
    @Override
    public void setConnection(Connection connection) throws Exception {
        this.connection=connection;
    }@Override
    public boolean AddCheff(Cheff cheff) throws Exception {
        String sql="Insert into  chef values(?,?,?,?,?,?)";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1,cheff.getChefID());
        pstm.setObject(2,cheff.getChefF_Name());
        pstm.setObject(3,cheff.getChefL_Name());
        pstm.setObject(4,cheff.getChefAddress());
        pstm.setObject(5,cheff.getChef_NicNO());
        pstm.setObject(6,cheff.getChefTel());

        return pstm.executeUpdate()>0;
    }

    @Override
    public boolean delete(String id) throws Exception {
        String sql="DELETE FROM chef WHERE chefID = ?";
        Connection connection=DBConnection.getInstance().getConnection();
        PreparedStatement pstm=connection.prepareStatement(sql);
        pstm.setObject(1,id);
        return pstm.executeUpdate()>0;
    }

    @Override
    public ArrayList<Cheff> getAllChef() throws Exception {
        ArrayList<Cheff> cheffs=new ArrayList<>();
        ResultSet set=CrudUtil.executeQuery("select * from chef");
        while (set.next()){
            cheffs.add(new Cheff(set.getString(1),set.getString(2),set.getString(3),set.getString(4),set.getString(5),set.getInt(6)));
        }
        return cheffs;
    }


}

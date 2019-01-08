package lk.ijse.student.dinemoreSystem.saver.daoLayer.impl;

import lk.ijse.student.dinemoreSystem.saver.daoLayer.custom.DeliverDAO;
import lk.ijse.student.dinemoreSystem.saver.entity.Deliver;

import java.sql.Connection;
import java.util.ArrayList;

public class DeliverDAOImpl implements DeliverDAO {
    @Override
    public boolean AddDeliver(Deliver deliver) throws Exception {
        return false;
    }

    @Override
    public boolean deleteDeliver(String id) throws Exception {
        return false;
    }

    @Override
    public ArrayList<Deliver> getAllChef() throws Exception {
        return null;
    }

    @Override
    public void setConnection(Connection connection) throws Exception {

    }
}

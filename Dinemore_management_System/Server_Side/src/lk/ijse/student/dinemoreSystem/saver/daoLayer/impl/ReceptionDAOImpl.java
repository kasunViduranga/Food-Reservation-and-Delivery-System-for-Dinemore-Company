package lk.ijse.student.dinemoreSystem.saver.daoLayer.impl;

import lk.ijse.student.dinemoreSystem.saver.daoLayer.custom.ReceptionDAO;
import lk.ijse.student.dinemoreSystem.saver.entity.Reception;

import java.sql.Connection;
import java.util.ArrayList;

public class ReceptionDAOImpl implements ReceptionDAO {
    @Override
    public boolean AddCheff(Reception reception) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return false;
    }

    @Override
    public ArrayList<Reception> getAllChef() throws Exception {
        return null;
    }

    @Override
    public void setConnection(Connection connection) throws Exception {

    }
}

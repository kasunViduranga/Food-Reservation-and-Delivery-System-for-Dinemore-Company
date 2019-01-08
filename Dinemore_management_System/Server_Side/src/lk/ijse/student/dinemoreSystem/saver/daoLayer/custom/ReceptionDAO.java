package lk.ijse.student.dinemoreSystem.saver.daoLayer.custom;

import lk.ijse.student.dinemoreSystem.saver.daoLayer.dao.CrudDAO;
import lk.ijse.student.dinemoreSystem.saver.entity.Cheff;
import lk.ijse.student.dinemoreSystem.saver.entity.Reception;

import java.util.ArrayList;

public interface ReceptionDAO extends CrudDAO {
    boolean AddCheff(Reception reception)throws Exception;
    boolean delete(String id)throws Exception;
    public ArrayList<Reception> getAllChef() throws Exception;
}

package lk.ijse.student.dinemoreSystem.saver.daoLayer.custom;

import lk.ijse.student.dinemoreSystem.saver.daoLayer.dao.CrudDAO;
import lk.ijse.student.dinemoreSystem.saver.entity.Cheff;

import java.util.ArrayList;

public interface ChefDAO extends CrudDAO {
    boolean AddCheff(Cheff cheff)throws Exception;
    boolean delete(String id)throws Exception;
    public ArrayList<Cheff> getAllChef() throws Exception;

}

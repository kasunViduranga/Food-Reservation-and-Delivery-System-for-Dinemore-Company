package lk.ijse.student.dinemoreSystem.saver.daoLayer.custom;

import lk.ijse.student.dinemoreSystem.saver.daoLayer.dao.CrudDAO;
import lk.ijse.student.dinemoreSystem.saver.entity.Deliver;

import java.util.ArrayList;

public interface DeliverDAO extends CrudDAO {
    boolean AddDeliver(Deliver deliver)throws Exception;
    boolean deleteDeliver(String id)throws Exception;
    public ArrayList<Deliver> getAllChef() throws Exception;
}

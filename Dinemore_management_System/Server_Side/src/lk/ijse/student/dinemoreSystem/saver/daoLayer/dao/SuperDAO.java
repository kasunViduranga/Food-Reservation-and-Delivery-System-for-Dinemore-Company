package lk.ijse.student.dinemoreSystem.saver.daoLayer.dao;

import java.sql.Connection;

public interface SuperDAO {
    public void setConnection(Connection connection)throws Exception;
}

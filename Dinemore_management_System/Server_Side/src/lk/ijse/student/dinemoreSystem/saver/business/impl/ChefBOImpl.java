package lk.ijse.student.dinemoreSystem.saver.business.impl;

import lk.ijse.student.dinemoreSystem.commen.dto.ChefDTO;
import lk.ijse.student.dinemoreSystem.saver.business.custom.ChefBO;
import lk.ijse.student.dinemoreSystem.saver.daoLayer.custom.ChefDAO;
import lk.ijse.student.dinemoreSystem.saver.daoLayer.dao.DAOFactory;
import lk.ijse.student.dinemoreSystem.saver.entity.Cheff;
import lk.ijse.student.dinemoreSystem.saver.resourse.DBConnection;

import java.sql.Connection;
import java.util.ArrayList;

public class ChefBOImpl implements ChefBO {
    private ChefDAO chefDAO;

    public ChefBOImpl() {
        chefDAO= (ChefDAO) DAOFactory.getInstance().getDAO(DAOFactory.BOTypes.CHEFF);

    }
    @Override
    public boolean AddChef(ChefDTO chefDTO) throws Exception {
        Connection connection=DBConnection.getInstance().getConnection();
        chefDAO.setConnection(connection);
        Cheff cheff=new Cheff(chefDTO.getChefID(),chefDTO.getChefF_Name(),chefDTO.getChefL_Name(),chefDTO.getChefAddress(),chefDTO.getChef_NicNO(),chefDTO.getChefTel());
        boolean b = chefDAO.AddCheff(cheff);
        return b;
    }

    @Override
    public boolean deleteChef(String id) throws Exception {
        Connection connection=DBConnection.getInstance().getConnection();
        chefDAO.setConnection(connection);
        boolean delete = chefDAO.delete(id);
        DBConnection.getInstance().releaseConnection(connection);
        return delete;
    }

    @Override
    public ChefDTO searchChef(String id) throws Exception {
        return null;
    }

    @Override
    public ArrayList<ChefDTO> getAllChef() throws Exception {
        Connection connection=DBConnection.getInstance().getConnection();
        chefDAO.setConnection(connection);
        ArrayList<ChefDTO> chefDTOS=new ArrayList<>();
        ArrayList<Cheff> allChef =chefDAO.getAllChef();
        for(Cheff chef:allChef){
            chefDTOS.add(new ChefDTO(chef.getChefID(),chef.getChefF_Name(),chef.getChefL_Name(),chef.getChefAddress(),chef.getChef_NicNO(),chef.getChefTel()));
        }
        DBConnection.getInstance().releaseConnection(connection);
        return chefDTOS;
    }
}

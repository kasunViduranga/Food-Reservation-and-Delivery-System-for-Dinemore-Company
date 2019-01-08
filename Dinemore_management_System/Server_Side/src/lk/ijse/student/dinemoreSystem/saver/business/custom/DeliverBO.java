package lk.ijse.student.dinemoreSystem.saver.business.custom;

import lk.ijse.student.dinemoreSystem.commen.dto.ChefDTO;
import lk.ijse.student.dinemoreSystem.saver.business.bo.SuperBO;

import java.util.ArrayList;

public interface DeliverBO extends SuperBO {
    boolean AddDeliver(ChefDTO chefDTO)throws Exception;
    boolean deleteDeliver(String id)throws Exception;
    ChefDTO searchDeliver(String id)throws Exception;
    ArrayList<ChefDTO> getAllDeliver()throws Exception;
}

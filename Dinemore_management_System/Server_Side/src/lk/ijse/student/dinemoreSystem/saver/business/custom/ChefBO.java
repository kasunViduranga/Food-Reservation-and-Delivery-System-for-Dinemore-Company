package lk.ijse.student.dinemoreSystem.saver.business.custom;

import lk.ijse.student.dinemoreSystem.commen.dto.ChefDTO;
import lk.ijse.student.dinemoreSystem.saver.business.bo.SuperBO;

import java.util.ArrayList;

public interface ChefBO extends SuperBO {
    boolean AddChef(ChefDTO chefDTO)throws Exception;
    boolean deleteChef(String id)throws Exception;
    ChefDTO searchChef(String id)throws Exception;
    ArrayList<ChefDTO> getAllChef()throws Exception;
}

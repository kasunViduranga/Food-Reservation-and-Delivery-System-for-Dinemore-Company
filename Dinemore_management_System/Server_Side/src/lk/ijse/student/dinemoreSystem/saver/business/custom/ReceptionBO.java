package lk.ijse.student.dinemoreSystem.saver.business.custom;

import lk.ijse.student.dinemoreSystem.commen.dto.ChefDTO;
import lk.ijse.student.dinemoreSystem.commen.dto.ReceptionDTO;
import lk.ijse.student.dinemoreSystem.saver.business.bo.SuperBO;

import java.util.ArrayList;

public interface ReceptionBO extends SuperBO {
    boolean AddChef(ReceptionDTO receptionDTO)throws Exception;
    boolean deleteChef(String id)throws Exception;
    ChefDTO searchChef(String id)throws Exception;
    ArrayList<ReceptionDTO> getAllChef()throws Exception;
}

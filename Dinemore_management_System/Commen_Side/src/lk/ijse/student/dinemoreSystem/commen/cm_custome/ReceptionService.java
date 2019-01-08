package lk.ijse.student.dinemoreSystem.commen.cm_custome;

import lk.ijse.student.dinemoreSystem.commen.cm_service.SuperService;
import lk.ijse.student.dinemoreSystem.commen.dto.ChefDTO;
import lk.ijse.student.dinemoreSystem.commen.dto.ReceptionDTO;

import java.util.ArrayList;

public interface ReceptionService extends SuperService {
    boolean addChef(ReceptionDTO receptionDTO)throws Exception;
    boolean DeleteChef(String id)throws Exception;
    ChefDTO searchChef(String id)throws Exception;
    ArrayList<ReceptionDTO> getAllChef()throws Exception;
}

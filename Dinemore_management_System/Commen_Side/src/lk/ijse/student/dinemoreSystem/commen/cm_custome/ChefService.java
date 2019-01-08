package lk.ijse.student.dinemoreSystem.commen.cm_custome;

import lk.ijse.student.dinemoreSystem.commen.cm_service.SuperService;
import lk.ijse.student.dinemoreSystem.commen.dto.ChefDTO;

import java.util.ArrayList;

public interface ChefService extends SuperService {
    boolean addChef(ChefDTO chefDTO)throws Exception;
    boolean DeleteChef(String id)throws Exception;
    ChefDTO searchChef(String id)throws Exception;
    ArrayList<ChefDTO> getAllChef()throws Exception;

}

package lk.ijse.student.dinemoreSystem.commen.cm_custome;

import lk.ijse.student.dinemoreSystem.commen.cm_service.SuperService;
import lk.ijse.student.dinemoreSystem.commen.dto.ChefDTO;
import lk.ijse.student.dinemoreSystem.commen.dto.DeliverDTO;

import java.util.ArrayList;

public interface DeliverService extends SuperService {
    boolean addDeliver(DeliverDTO deliverDTO)throws Exception;
    boolean DeleteDeliver(String id)throws Exception;
    ChefDTO searchDeliver(String id)throws Exception;
    ArrayList<DeliverDTO> getAllDeliver()throws Exception;
}

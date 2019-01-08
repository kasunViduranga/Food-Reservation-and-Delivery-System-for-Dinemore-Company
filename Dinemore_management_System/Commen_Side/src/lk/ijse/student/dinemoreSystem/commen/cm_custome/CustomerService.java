package lk.ijse.student.dinemoreSystem.commen.cm_custome;

import lk.ijse.student.dinemoreSystem.commen.cm_service.SuperService;
import lk.ijse.student.dinemoreSystem.commen.dto.ChefDTO;
import lk.ijse.student.dinemoreSystem.commen.dto.CommonDTO;

public interface CustomerService extends SuperService {
    boolean saveCustomer(CommonDTO dto)throws Exception;

}

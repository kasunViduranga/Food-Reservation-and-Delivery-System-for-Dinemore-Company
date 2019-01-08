package lk.ijse.student.dinemoreSystem.commen.cm_custome;

import lk.ijse.student.dinemoreSystem.commen.cm_service.SuperService;
import lk.ijse.student.dinemoreSystem.commen.dto.ChefDTO;
import lk.ijse.student.dinemoreSystem.commen.dto.FoodDTO;
import lk.ijse.student.dinemoreSystem.commen.dto.OrderDetailsDTO;

import java.util.ArrayList;

public interface FoodService extends SuperService {
    boolean addFood(OrderDetailsDTO orderDetailsDTO)throws Exception;
    boolean DeleteFood(String id)throws Exception;
    FoodDTO searchFood(String id)throws Exception;
    ArrayList<FoodDTO> getAllFood()throws Exception;
    ArrayList<OrderDetailsDTO> getAllOrderDetails()throws Exception;
}

package lk.ijse.student.dinemoreSystem.saver.business.custom;

import lk.ijse.student.dinemoreSystem.commen.dto.ChefDTO;
import lk.ijse.student.dinemoreSystem.commen.dto.FoodDTO;
import lk.ijse.student.dinemoreSystem.commen.dto.OrderDetailsDTO;
import lk.ijse.student.dinemoreSystem.saver.business.bo.SuperBO;

import java.util.ArrayList;

public interface FoodBO extends SuperBO {
    boolean AddFood(OrderDetailsDTO orderDetailsDTO)throws Exception;
    boolean deleteFood(String id)throws Exception;
    FoodDTO searchFood(String id)throws Exception;
    ArrayList<FoodDTO> getAllFood()throws Exception;
    ArrayList<OrderDetailsDTO> getAllOrderDetails()throws Exception;
}

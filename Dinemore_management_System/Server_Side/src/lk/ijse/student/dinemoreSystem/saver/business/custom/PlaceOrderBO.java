package lk.ijse.student.dinemoreSystem.saver.business.custom;

import lk.ijse.student.dinemoreSystem.commen.dto.ChefDTO;
import lk.ijse.student.dinemoreSystem.commen.dto.OrderDetailsDTO;
import lk.ijse.student.dinemoreSystem.commen.dto.PlaceOrderDTO;
import lk.ijse.student.dinemoreSystem.saver.business.bo.SuperBO;

import java.util.ArrayList;

public interface PlaceOrderBO extends SuperBO {
    ArrayList<PlaceOrderDTO> getAllPlaceOrder()throws Exception;
    boolean deplaceOrderUpdate(PlaceOrderDTO dto)throws Exception;
    ArrayList<OrderDetailsDTO> getAllOrderDetails(String id)throws Exception;
    ArrayList<PlaceOrderDTO> getAllorderToDeliver()throws Exception;
}

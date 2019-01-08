package lk.ijse.student.dinemoreSystem.commen.cm_custome;

import lk.ijse.student.dinemoreSystem.commen.cm_service.SuperService;
import lk.ijse.student.dinemoreSystem.commen.dto.OrderDetailsDTO;
import lk.ijse.student.dinemoreSystem.commen.dto.PlaceOrderDTO;

import java.util.ArrayList;

public interface PlaceOrderService extends SuperService {
    ArrayList<PlaceOrderDTO> getAllPlaceOrder()throws Exception;
    boolean placeOrderUpdate(PlaceOrderDTO dto)throws Exception;
    ArrayList<OrderDetailsDTO> getAllOrderDetails(String id)throws Exception;
    ArrayList<PlaceOrderDTO> getAllOrderToDeliver()throws Exception;
}

package lk.ijse.student.dinemoreSystem.saver.daoLayer.custom;

import lk.ijse.student.dinemoreSystem.saver.daoLayer.dao.CrudDAO;
import lk.ijse.student.dinemoreSystem.saver.entity.OrderDetails;
import lk.ijse.student.dinemoreSystem.saver.entity.PlaceOrder;

import java.util.ArrayList;

public interface PlaceOrderDAO extends CrudDAO<PlaceOrder, String> {
    boolean savePlaceOrder(PlaceOrder entity)throws Exception;
    public ArrayList<PlaceOrder> getAllPlaceOrder() throws Exception;
    boolean placeOrderUpdate(PlaceOrder entity)throws Exception;
    public ArrayList<OrderDetails> getAllOrderDetails(String id) throws Exception;
    public ArrayList<PlaceOrder> getAllOrderToDeliver() throws Exception;
}

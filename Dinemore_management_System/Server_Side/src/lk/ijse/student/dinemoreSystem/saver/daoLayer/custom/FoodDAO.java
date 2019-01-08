package lk.ijse.student.dinemoreSystem.saver.daoLayer.custom;

import lk.ijse.student.dinemoreSystem.saver.daoLayer.dao.CrudDAO;
import lk.ijse.student.dinemoreSystem.saver.entity.Cheff;
import lk.ijse.student.dinemoreSystem.saver.entity.Food;
import lk.ijse.student.dinemoreSystem.saver.entity.OrderDetails;

import java.util.ArrayList;

public interface FoodDAO extends CrudDAO {
    boolean AddFood(OrderDetails orderDetails)throws Exception;
    boolean deleteFood(String id)throws Exception;
    public ArrayList<Food> getAllFood() throws Exception;
    Food SearchFood(String id)throws Exception;
    public ArrayList<OrderDetails> getAllOrderDetails() throws Exception;
}

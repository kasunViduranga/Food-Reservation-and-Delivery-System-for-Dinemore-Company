package lk.ijse.student.dinemoreSystem.saver.business.impl;

import lk.ijse.student.dinemoreSystem.commen.dto.ChefDTO;
import lk.ijse.student.dinemoreSystem.commen.dto.FoodDTO;
import lk.ijse.student.dinemoreSystem.commen.dto.OrderDetailsDTO;
import lk.ijse.student.dinemoreSystem.saver.business.custom.FoodBO;
import lk.ijse.student.dinemoreSystem.saver.daoLayer.custom.FoodDAO;
import lk.ijse.student.dinemoreSystem.saver.daoLayer.dao.DAOFactory;
import lk.ijse.student.dinemoreSystem.saver.entity.Food;
import lk.ijse.student.dinemoreSystem.saver.entity.OrderDetails;
import lk.ijse.student.dinemoreSystem.saver.resourse.DBConnection;

import java.sql.Connection;
import java.util.ArrayList;

public class FoodBOImpl implements FoodBO {
    private FoodDAO foodDAO;

    public FoodBOImpl() {
        foodDAO= (FoodDAO) DAOFactory.getInstance().getDAO(DAOFactory.BOTypes.FOOD);
    }

    @Override
    public boolean AddFood(OrderDetailsDTO orderDetailsDTO) throws Exception {
        Connection connection=DBConnection.getInstance().getConnection();
        foodDAO.setConnection(connection);
        OrderDetails orderDetails=new OrderDetails(orderDetailsDTO.getOrderID(),orderDetailsDTO.getItemName(),orderDetailsDTO.getQty());
        boolean result=foodDAO.AddFood(orderDetails);
        DBConnection.getInstance().releaseConnection(connection);

        return result;
    }

    @Override
    public boolean deleteFood(String id) throws Exception {
        return false;
    }

    @Override
    public FoodDTO searchFood(String id) throws Exception {
        Connection connection=DBConnection.getInstance().getConnection();
        foodDAO.setConnection(connection);
        Food food=foodDAO.SearchFood(id);
        FoodDTO dto=new FoodDTO(food.getItemCode(),food.getItemName(),food.getItemDescription(),food.getPrise());
        DBConnection.getInstance().releaseConnection(connection);
        return dto;
    }

    @Override
    public ArrayList<FoodDTO> getAllFood() throws Exception {
        Connection connection=DBConnection.getInstance().getConnection();
        foodDAO.setConnection(connection);
        ArrayList<FoodDTO> dtos=new ArrayList<>();
        ArrayList<Food> foods=foodDAO.getAllFood();
        for (Food food:foods){
            dtos.add(new FoodDTO(food.getItemCode(),food.getItemName(),food.getItemDescription(),food.getPrise()));

        }
        DBConnection.getInstance().releaseConnection(connection);
        return dtos;
    }

    @Override
    public ArrayList<OrderDetailsDTO> getAllOrderDetails() throws Exception {
        Connection connection=DBConnection.getInstance().getConnection();
        foodDAO.setConnection(connection);
        ArrayList<OrderDetailsDTO> dtos=new ArrayList<>();
        ArrayList<OrderDetails> details=foodDAO.getAllOrderDetails();
        for (OrderDetails d:details){
            dtos.add(new OrderDetailsDTO(d.getOrderID(),d.getItemName(),d.getQty()));
        }
        return dtos;
    }
}

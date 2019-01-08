package lk.ijse.student.dinemoreSystem.saver.service.cm_impl;

import lk.ijse.student.dinemoreSystem.commen.cm_custome.FoodService;
import lk.ijse.student.dinemoreSystem.commen.dto.ChefDTO;
import lk.ijse.student.dinemoreSystem.commen.dto.FoodDTO;
import lk.ijse.student.dinemoreSystem.commen.dto.OrderDetailsDTO;
import lk.ijse.student.dinemoreSystem.saver.business.bo.BoFactory;
import lk.ijse.student.dinemoreSystem.saver.business.custom.FoodBO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class FoodServiceImpl extends UnicastRemoteObject implements FoodService {

    private FoodBO foodBO;
    public FoodServiceImpl() throws RemoteException {
        foodBO= (FoodBO) BoFactory.getInstance().getBO(BoFactory.BOTypes.FOOD);
    }


    @Override
    public boolean addFood(OrderDetailsDTO orderDetailsDTO) throws Exception {
        boolean b=foodBO.AddFood(orderDetailsDTO);
        return b;

    }

    @Override
    public boolean DeleteFood(String id) throws Exception {
        return false;
    }

    @Override
    public FoodDTO searchFood(String id) throws Exception {
        FoodDTO dto=foodBO.searchFood(id);
        FoodDTO food=new FoodDTO(dto.getItemCode(),dto.getItemName(),dto.getItemDescription(),dto.getPrise());
        return food;
    }

    @Override
    public ArrayList<FoodDTO> getAllFood() throws Exception {
        ArrayList<FoodDTO> allFood=foodBO.getAllFood();
        return allFood;
    }

    @Override
    public ArrayList<OrderDetailsDTO> getAllOrderDetails() throws Exception {
        ArrayList<OrderDetailsDTO> detailsDTOS=foodBO.getAllOrderDetails();
        return detailsDTOS;
    }
}

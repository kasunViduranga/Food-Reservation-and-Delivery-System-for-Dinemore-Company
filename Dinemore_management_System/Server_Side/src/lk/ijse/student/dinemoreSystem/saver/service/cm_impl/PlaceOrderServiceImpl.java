package lk.ijse.student.dinemoreSystem.saver.service.cm_impl;

import lk.ijse.student.dinemoreSystem.commen.cm_custome.PlaceOrderService;
import lk.ijse.student.dinemoreSystem.commen.dto.OrderDetailsDTO;
import lk.ijse.student.dinemoreSystem.commen.dto.PlaceOrderDTO;
import lk.ijse.student.dinemoreSystem.saver.business.bo.BoFactory;
import lk.ijse.student.dinemoreSystem.saver.business.custom.PlaceOrderBO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class PlaceOrderServiceImpl extends UnicastRemoteObject implements PlaceOrderService {
    private PlaceOrderBO placeOrderBO;

    public PlaceOrderServiceImpl() throws RemoteException {
        placeOrderBO= (PlaceOrderBO) BoFactory.getInstance().getBO(BoFactory.BOTypes.PLACEORDER);
    }

    @Override
    public ArrayList<PlaceOrderDTO> getAllPlaceOrder() throws Exception {
        ArrayList<PlaceOrderDTO> placeOrderDTOS=new ArrayList<>();
        ArrayList<PlaceOrderDTO> allPlaceOrder=placeOrderBO.getAllPlaceOrder();
        for(PlaceOrderDTO orderDTO: allPlaceOrder){
            placeOrderDTOS.add(new PlaceOrderDTO(orderDTO.getOrederID(),orderDTO.getCustomerID(),orderDTO.getOrderDate(),orderDTO.getOrderQty(),orderDTO.getUnitPrice(),orderDTO.getStates()));
        }
        return placeOrderDTOS;

    }

    @Override
    public boolean placeOrderUpdate(PlaceOrderDTO dto) throws Exception {
        return placeOrderBO.deplaceOrderUpdate(dto);
    }

    @Override
    public ArrayList<OrderDetailsDTO> getAllOrderDetails(String id) throws Exception {
        ArrayList<OrderDetailsDTO> orderDetailsDTOS=new ArrayList<>();
        ArrayList<OrderDetailsDTO> allDetails=placeOrderBO.getAllOrderDetails(id);
        for(OrderDetailsDTO detailsDTO: allDetails){
            orderDetailsDTOS.add(new OrderDetailsDTO(detailsDTO.getOrderID(),detailsDTO.getItemName(),detailsDTO.getQty()));
        }
        return orderDetailsDTOS;
    }

    @Override
    public ArrayList<PlaceOrderDTO> getAllOrderToDeliver() throws Exception {
        ArrayList<PlaceOrderDTO> placeOrderDTO=new ArrayList<>();
        ArrayList<PlaceOrderDTO> allPlaceOrder=placeOrderBO.getAllorderToDeliver();
        for(PlaceOrderDTO orderDTO: allPlaceOrder){
            placeOrderDTO.add(new PlaceOrderDTO(orderDTO.getOrederID(),orderDTO.getCustomerID(),orderDTO.getOrderDate(),orderDTO.getOrderQty(),orderDTO.getUnitPrice(),orderDTO.getStates()));
        }
        return placeOrderDTO;
    }
}

package lk.ijse.student.dinemoreSystem.saver.business.impl;

import lk.ijse.student.dinemoreSystem.commen.dto.ChefDTO;
import lk.ijse.student.dinemoreSystem.commen.dto.OrderDetailsDTO;
import lk.ijse.student.dinemoreSystem.commen.dto.PlaceOrderDTO;
import lk.ijse.student.dinemoreSystem.saver.business.custom.PlaceOrderBO;
import lk.ijse.student.dinemoreSystem.saver.daoLayer.custom.ChefDAO;
import lk.ijse.student.dinemoreSystem.saver.daoLayer.custom.PlaceOrderDAO;
import lk.ijse.student.dinemoreSystem.saver.daoLayer.dao.DAOFactory;
import lk.ijse.student.dinemoreSystem.saver.entity.Cheff;
import lk.ijse.student.dinemoreSystem.saver.entity.OrderDetails;
import lk.ijse.student.dinemoreSystem.saver.entity.PlaceOrder;
import lk.ijse.student.dinemoreSystem.saver.resourse.DBConnection;

import java.sql.Connection;
import java.util.ArrayList;

public class PlaceOrderBOImpl implements PlaceOrderBO {
    private PlaceOrderDAO placeOrderDAO;

    public PlaceOrderBOImpl() {
        placeOrderDAO= (PlaceOrderDAO) DAOFactory.getInstance().getDAO(DAOFactory.BOTypes.PLACEORDER);
    }

    @Override
    public ArrayList<PlaceOrderDTO> getAllPlaceOrder() throws Exception {
        Connection connection=DBConnection.getInstance().getConnection();
        placeOrderDAO.setConnection(connection);
        ArrayList<PlaceOrderDTO> placeOrderDTOS=new ArrayList<>();
        ArrayList<PlaceOrder> allChef =placeOrderDAO.getAllPlaceOrder();
        for(PlaceOrder order:allChef){
            placeOrderDTOS.add(new PlaceOrderDTO(order.getOrederID(),order.getCustomerID(),order.getOrderDate(),order.getOrderQty(),order.getUnitPrice(),order.getStates()));
        }
        DBConnection.getInstance().releaseConnection(connection);
        return placeOrderDTOS;
    }

    @Override
    public boolean deplaceOrderUpdate(PlaceOrderDTO dto) throws Exception {
        Connection connection=DBConnection.getInstance().getConnection();
        placeOrderDAO.setConnection(connection);
        boolean b=placeOrderDAO.placeOrderUpdate(new PlaceOrder(dto.getOrederID(),dto.getCustomerID(),dto.getOrderDate(),dto.getOrderQty(),dto.getUnitPrice(),dto.getStates()));
        DBConnection.getInstance().releaseConnection(connection);
        return b;
    }

    @Override
    public ArrayList<OrderDetailsDTO> getAllOrderDetails(String id) throws Exception {
        Connection connection=DBConnection.getInstance().getConnection();
        placeOrderDAO.setConnection(connection);
        ArrayList<OrderDetailsDTO> detailsDTOS=new ArrayList<>();
        ArrayList<OrderDetails> allDetails=placeOrderDAO.getAllOrderDetails(id);
        for (OrderDetails details:allDetails){
            detailsDTOS.add(new OrderDetailsDTO(details.getOrderID(),details.getItemName(),details.getQty()));
        }
        DBConnection.getInstance().releaseConnection(connection);
        return detailsDTOS;
    }

    @Override
    public ArrayList<PlaceOrderDTO> getAllorderToDeliver() throws Exception {
        Connection connection=DBConnection.getInstance().getConnection();
        placeOrderDAO.setConnection(connection);
        ArrayList<PlaceOrderDTO> placeOrderDTOS=new ArrayList<>();
        ArrayList<PlaceOrder> allChef =placeOrderDAO.getAllOrderToDeliver();
        for(PlaceOrder order:allChef){
            placeOrderDTOS.add(new PlaceOrderDTO(order.getOrederID(),order.getCustomerID(),order.getOrderDate(),order.getOrderQty(),order.getUnitPrice(),order.getStates()));
        }
        DBConnection.getInstance().releaseConnection(connection);
        return placeOrderDTOS;
    }
}

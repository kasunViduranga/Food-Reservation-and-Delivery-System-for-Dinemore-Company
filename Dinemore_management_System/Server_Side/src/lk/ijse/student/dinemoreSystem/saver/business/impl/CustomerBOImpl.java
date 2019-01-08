package lk.ijse.student.dinemoreSystem.saver.business.impl;

import lk.ijse.student.dinemoreSystem.commen.dto.CommonDTO;
import lk.ijse.student.dinemoreSystem.saver.business.custom.CustomerBO;
import lk.ijse.student.dinemoreSystem.saver.daoLayer.custom.CustomerDAO;
import lk.ijse.student.dinemoreSystem.saver.daoLayer.custom.PlaceOrderDAO;
import lk.ijse.student.dinemoreSystem.saver.daoLayer.dao.DAOFactory;
import lk.ijse.student.dinemoreSystem.saver.entity.Customer;
import lk.ijse.student.dinemoreSystem.saver.entity.PlaceOrder;
import lk.ijse.student.dinemoreSystem.saver.resourse.DBConnection;

import java.sql.Connection;

public class CustomerBOImpl implements CustomerBO {
    private CustomerDAO customerDAO;
    boolean add;
    PlaceOrderDAO placeOrderDAO;
    public CustomerBOImpl() {
        customerDAO= (CustomerDAO) DAOFactory.getInstance().getDAO(DAOFactory.BOTypes.CUSTOMER);
        placeOrderDAO= (PlaceOrderDAO) DAOFactory.getInstance().getDAO(DAOFactory.BOTypes.PLACEORDER);
    }

    @Override
    public boolean savetransacrtion(CommonDTO dto) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        customerDAO.setConnection(connection);
        connection.setAutoCommit(false);

        try {
            Customer customer = new Customer(dto.getCustomerDTO().getCusID(), dto.getCustomerDTO().getCusName(), dto.getCustomerDTO().getCusAddress(), dto.getCustomerDTO().getCusNIC(), dto.getCustomerDTO().getCusTell());
            add = customerDAO.seveTransectionCustomer(customer);
            if (!add) {
                connection.rollback();
                return false;
            }
            PlaceOrder order = new PlaceOrder(dto.getPlaceOrderDTO().getOrederID(), dto.getPlaceOrderDTO().getCustomerID(), dto.getPlaceOrderDTO().getOrderDate(), dto.getPlaceOrderDTO().getOrderQty(), dto.getPlaceOrderDTO().getUnitPrice(),dto.getPlaceOrderDTO().getStates());
            add = placeOrderDAO.savePlaceOrder(order);
            if (!add) {
                connection.rollback();
                return false;
            }
            connection.commit();
            return true;
        } finally {
            DBConnection.getInstance().releaseConnection(connection);
            connection.commit();
            return true;
        }
    }
}

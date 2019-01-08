package lk.ijse.student.dinemoreSystem.saver.daoLayer.dao;

import lk.ijse.student.dinemoreSystem.saver.daoLayer.impl.*;

public class DAOFactory {
    public enum  BOTypes {
        CUSTOMER,DELIVER,RECEPTION,CHEFF,PLACEORDER,FOOD
    }
    private static DAOFactory daoFactory;

    private DAOFactory(){

    }

    public static DAOFactory getInstance(){
        if(daoFactory==null) {
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }
    public SuperDAO getDAO(BOTypes type){
        switch (type){
            case CHEFF:
                return new ChefDAOImpl();
            case DELIVER:
                return new DeliverDAOImpl();
            case RECEPTION:
                return new ReceptionDAOImpl();
            case CUSTOMER:
                return new CustomerDAOImpl();
            case PLACEORDER:
                return new PlaceOrderDAOImpl();
            case FOOD:
                return new FoodDAOImpl();
            default:
                return null;
        }
    }
}

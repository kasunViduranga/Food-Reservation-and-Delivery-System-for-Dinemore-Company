package lk.ijse.student.dinemoreSystem.saver.business.bo;

import lk.ijse.student.dinemoreSystem.saver.business.impl.*;

public class BoFactory {
    public enum  BOTypes {
        CHEF,DELIVER,RECEPTION,CUSTOMER,PLACEORDER,FOOD
    }
    private static BoFactory boFactory;

    private BoFactory(){

    }

    public static BoFactory getInstance(){
        if(boFactory==null) {
            boFactory = new BoFactory();
        }
        return boFactory;
    }
    public SuperBO getBO(BOTypes type){

        switch (type){
            case CHEF:
                return new ChefBOImpl();
            case DELIVER:
                return new DeliverBOImpl();
            case RECEPTION:
                return new ReceptionBOImpl();
            case CUSTOMER:
                return new CustomerBOImpl();
            case PLACEORDER:
                return new PlaceOrderBOImpl();
            case FOOD:
                return new FoodBOImpl();
            default:
                return null;
        }
    }
}

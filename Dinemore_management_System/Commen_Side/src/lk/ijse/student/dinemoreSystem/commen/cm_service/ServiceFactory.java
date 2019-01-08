package lk.ijse.student.dinemoreSystem.commen.cm_service;

import java.rmi.Remote;

public interface ServiceFactory extends Remote {
    public enum serviceType{
        CHEFF,CUSTOMER,PLACEORDER,FOOD
    }
    public SuperService getService(serviceType types) throws Exception;
}

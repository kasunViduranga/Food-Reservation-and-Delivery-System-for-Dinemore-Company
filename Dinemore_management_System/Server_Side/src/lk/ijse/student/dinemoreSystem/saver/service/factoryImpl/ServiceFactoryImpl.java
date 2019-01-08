package lk.ijse.student.dinemoreSystem.saver.service.factoryImpl;

import com.sun.deploy.services.Service;
import lk.ijse.student.dinemoreSystem.commen.cm_service.ServiceFactory;
import lk.ijse.student.dinemoreSystem.commen.cm_service.SuperService;
import lk.ijse.student.dinemoreSystem.saver.service.cm_impl.ChefServiceImpl;
import lk.ijse.student.dinemoreSystem.saver.service.cm_impl.CustomerSaviceImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import static lk.ijse.student.dinemoreSystem.saver.daoLayer.dao.DAOFactory.BOTypes.CUSTOMER;

public class ServiceFactoryImpl extends UnicastRemoteObject implements ServiceFactory {
    public static ServiceFactory serviceFactory;
    public ServiceFactoryImpl() throws RemoteException {
    }

    public  static ServiceFactory getInstance() throws RemoteException {
        if(serviceFactory==null){
            serviceFactory=new ServiceFactoryImpl();
        }
        return serviceFactory;
    }

    @Override
    public SuperService getService(serviceType types) throws Exception {
        switch (types){
            case CHEFF:
                return new ChefServiceImpl();
            case CUSTOMER:
                return new CustomerSaviceImpl();
            default:
                return null;
        }
    }
}

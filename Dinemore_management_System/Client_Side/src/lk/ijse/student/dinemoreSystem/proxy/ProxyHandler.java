package lk.ijse.student.dinemoreSystem.proxy;

import lk.ijse.student.dinemoreSystem.commen.cm_custome.ChefService;
import lk.ijse.student.dinemoreSystem.commen.cm_custome.CustomerService;
import lk.ijse.student.dinemoreSystem.commen.cm_custome.FoodService;
import lk.ijse.student.dinemoreSystem.commen.cm_custome.PlaceOrderService;
import lk.ijse.student.dinemoreSystem.commen.cm_service.ServiceFactory;
import lk.ijse.student.dinemoreSystem.commen.cm_service.SuperService;
import lk.ijse.student.dinemoreSystem.saver.service.cm_impl.ChefServiceImpl;
import lk.ijse.student.dinemoreSystem.saver.service.cm_impl.CustomerSaviceImpl;
import lk.ijse.student.dinemoreSystem.saver.service.cm_impl.FoodServiceImpl;
import lk.ijse.student.dinemoreSystem.saver.service.cm_impl.PlaceOrderServiceImpl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ProxyHandler implements ServiceFactory {
    private static ProxyHandler proxyHandler;
    private ServiceFactory serviceFactory;
    private ChefService chefService;
    private CustomerService customerServices;
    private PlaceOrderService placeOrderService;
    private FoodService foodService;

    public ProxyHandler(){
        try {
            serviceFactory= (ServiceFactory) Naming.lookup("rmi://localhost:5050/dinermore");
             chefService = (ChefService) serviceFactory.getService(serviceType.CHEFF);
             customerServices= (CustomerService) serviceFactory.getService(serviceType.CUSTOMER);
             placeOrderService= (PlaceOrderService) serviceFactory.getService(serviceType.PLACEORDER);
             foodService= (FoodService) serviceFactory.getService(serviceType.FOOD);
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static ProxyHandler getInstance(){
        if (proxyHandler==null){
            proxyHandler=new ProxyHandler();
        }
        return proxyHandler;
    }

    @Override
    public SuperService getService(serviceType types) throws Exception {
        switch (types){
            case CHEFF:
                return new ChefServiceImpl();
            case CUSTOMER:
                return new CustomerSaviceImpl();
            case PLACEORDER:
                return new PlaceOrderServiceImpl();
            case FOOD:
                return new FoodServiceImpl();
                default:
                    return null;
        }
    }
}

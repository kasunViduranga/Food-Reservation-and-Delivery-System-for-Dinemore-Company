package lk.ijse.student.dinemoreSystem.saver.startUp;

import lk.ijse.student.dinemoreSystem.saver.service.factoryImpl.ServiceFactoryImpl;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class StartUp {
    public static void main(String[] args){
        try {
            Registry registry = LocateRegistry.createRegistry(5050);
            registry.rebind("dinermore", ServiceFactoryImpl.getInstance());
            System.out.println("Server is Running Successfully...");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}

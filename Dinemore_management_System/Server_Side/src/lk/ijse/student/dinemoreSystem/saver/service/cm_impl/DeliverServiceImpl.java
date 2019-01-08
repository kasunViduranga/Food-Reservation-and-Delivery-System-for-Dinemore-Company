package lk.ijse.student.dinemoreSystem.saver.service.cm_impl;

import lk.ijse.student.dinemoreSystem.commen.cm_custome.DeliverService;
import lk.ijse.student.dinemoreSystem.commen.dto.ChefDTO;
import lk.ijse.student.dinemoreSystem.commen.dto.DeliverDTO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class DeliverServiceImpl extends UnicastRemoteObject implements DeliverService {

    protected DeliverServiceImpl() throws RemoteException {

    }

    @Override
    public boolean addDeliver(DeliverDTO deliverDTO) throws Exception {
        return false;
    }

    @Override
    public boolean DeleteDeliver(String id) throws Exception {
        return false;
    }

    @Override
    public ChefDTO searchDeliver(String id) throws Exception {
        return null;
    }

    @Override
    public ArrayList<DeliverDTO> getAllDeliver() throws Exception {
        return null;
    }
}

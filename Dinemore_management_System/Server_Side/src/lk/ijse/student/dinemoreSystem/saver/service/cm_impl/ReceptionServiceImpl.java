package lk.ijse.student.dinemoreSystem.saver.service.cm_impl;

import lk.ijse.student.dinemoreSystem.commen.cm_custome.ReceptionService;
import lk.ijse.student.dinemoreSystem.commen.dto.ChefDTO;
import lk.ijse.student.dinemoreSystem.commen.dto.ReceptionDTO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ReceptionServiceImpl extends UnicastRemoteObject implements ReceptionService {

    protected ReceptionServiceImpl() throws RemoteException {
    }

    @Override
    public boolean addChef(ReceptionDTO receptionDTO) throws Exception {
        return false;
    }

    @Override
    public boolean DeleteChef(String id) throws Exception {
        return false;
    }

    @Override
    public ChefDTO searchChef(String id) throws Exception {
        return null;
    }

    @Override
    public ArrayList<ReceptionDTO> getAllChef() throws Exception {
        return null;
    }
}

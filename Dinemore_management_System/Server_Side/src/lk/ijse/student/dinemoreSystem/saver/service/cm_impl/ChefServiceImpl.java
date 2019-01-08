package lk.ijse.student.dinemoreSystem.saver.service.cm_impl;

import lk.ijse.student.dinemoreSystem.commen.cm_custome.ChefService;
import lk.ijse.student.dinemoreSystem.commen.dto.ChefDTO;
import lk.ijse.student.dinemoreSystem.saver.business.bo.BoFactory;
import lk.ijse.student.dinemoreSystem.saver.business.custom.ChefBO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ChefServiceImpl extends UnicastRemoteObject implements ChefService {
    private ChefBO chefBO;

    public ChefServiceImpl() throws RemoteException {
        chefBO = (ChefBO) BoFactory.getInstance().getBO(BoFactory.BOTypes.CHEF);
    }

    @Override
    public boolean addChef(ChefDTO chefDTO) throws Exception {
        return chefBO.AddChef(chefDTO);
    }

    @Override
    public boolean DeleteChef(String id) throws Exception {
        boolean delete=chefBO.deleteChef(id);
        return delete;
    }

    @Override
    public ChefDTO searchChef(String id) throws Exception {
        return null;
    }

    @Override
    public ArrayList<ChefDTO> getAllChef() throws Exception {
        ArrayList<ChefDTO> chefDTOS=new ArrayList<>();
        ArrayList<ChefDTO> allChef=chefBO.getAllChef();
        for(ChefDTO chef: allChef){
            chefDTOS.add(new ChefDTO(chef.getChefID(),chef.getChefF_Name(),chef.getChefL_Name(),chef.getChefAddress(),chef.getChef_NicNO(),chef.getChefTel()));
        }
        return chefDTOS;
    }
}

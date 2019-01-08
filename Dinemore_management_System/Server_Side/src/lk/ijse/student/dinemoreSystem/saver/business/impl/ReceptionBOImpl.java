package lk.ijse.student.dinemoreSystem.saver.business.impl;

import lk.ijse.student.dinemoreSystem.commen.dto.ChefDTO;
import lk.ijse.student.dinemoreSystem.commen.dto.ReceptionDTO;
import lk.ijse.student.dinemoreSystem.saver.business.custom.ReceptionBO;

import java.util.ArrayList;

public class ReceptionBOImpl implements ReceptionBO {
    @Override
    public boolean AddChef(ReceptionDTO receptionDTO) throws Exception {
        return false;
    }

    @Override
    public boolean deleteChef(String id) throws Exception {
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

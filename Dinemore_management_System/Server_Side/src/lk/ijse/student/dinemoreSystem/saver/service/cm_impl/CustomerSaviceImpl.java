package lk.ijse.student.dinemoreSystem.saver.service.cm_impl;

import lk.ijse.student.dinemoreSystem.commen.cm_custome.CustomerService;
import lk.ijse.student.dinemoreSystem.commen.dto.CommonDTO;
import lk.ijse.student.dinemoreSystem.saver.business.bo.BoFactory;
import lk.ijse.student.dinemoreSystem.saver.business.custom.CustomerBO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CustomerSaviceImpl extends UnicastRemoteObject implements CustomerService {
private CustomerBO customerBO;
    public CustomerSaviceImpl() throws RemoteException {
        customerBO= (CustomerBO) BoFactory.getInstance().getBO(BoFactory.BOTypes.CUSTOMER);
    }

    @Override
    public boolean saveCustomer(CommonDTO dto) throws Exception {
        return customerBO.savetransacrtion(dto);
    }
}

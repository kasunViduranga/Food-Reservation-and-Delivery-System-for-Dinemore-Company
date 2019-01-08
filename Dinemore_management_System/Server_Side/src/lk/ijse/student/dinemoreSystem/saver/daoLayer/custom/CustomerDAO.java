package lk.ijse.student.dinemoreSystem.saver.daoLayer.custom;

import lk.ijse.student.dinemoreSystem.saver.daoLayer.dao.CrudDAO;
import lk.ijse.student.dinemoreSystem.saver.entity.Customer;

public interface CustomerDAO extends CrudDAO<Customer,String> {
    boolean seveTransectionCustomer(Customer entity)throws Exception;
}

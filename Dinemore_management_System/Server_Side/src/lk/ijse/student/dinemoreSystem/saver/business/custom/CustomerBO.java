package lk.ijse.student.dinemoreSystem.saver.business.custom;

import lk.ijse.student.dinemoreSystem.commen.dto.CommonDTO;
import lk.ijse.student.dinemoreSystem.saver.business.bo.SuperBO;

public interface CustomerBO extends SuperBO {
    boolean savetransacrtion(CommonDTO dto)throws Exception;
}

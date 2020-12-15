package example.pc.service.serviceImpl;

import example.pc.dao.impl.EquipmentDao;
import example.pc.entity.Equipment;
import example.pc.service.IEquitmentService;

import java.util.List;

public class EquitmentServiceImpl implements IEquitmentService {

    EquipmentDao equipmentDao = new EquipmentDao();
    @Override
    public List<Equipment> getEquipments(){
        List<Equipment> all = equipmentDao.getAll();
        return all;
    }
}

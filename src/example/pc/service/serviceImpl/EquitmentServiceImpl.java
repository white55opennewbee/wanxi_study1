package example.pc.service.serviceImpl;

import example.pc.dao.EquitmentDao;
import example.pc.entity.Equipment;
import example.pc.service.IEquitmentService;

import java.util.List;

public class EquitmentServiceImpl implements IEquitmentService {

    EquitmentDao equitmentDao = new EquitmentDao();

    public List<Equipment> getEquipments(){
        List<Equipment> all = equitmentDao.getAll();
        for (Equipment e:all){
            e.setImgUrl("img/"+e.getImgUrl());
        }
        return all;
    }
}

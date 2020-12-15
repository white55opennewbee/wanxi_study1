package example.pc.dao.impl;

import example.pc.Utils.ClassReflictionForDaoUtil;
import example.pc.Utils.Jdbc_Utils;
import example.pc.Utils.Mybatis_Utils;
import example.pc.dao.IEquipmentMapper;
import example.pc.entity.Equipment;
import org.apache.ibatis.session.SqlSession;


import java.util.ArrayList;
import java.util.List;

public class EquipmentDao implements IEquipmentMapper {

    @Override
   public List<Equipment> getAll(){
        SqlSession sqlsession = Mybatis_Utils.getSqlsession();
        IEquipmentMapper mapper = sqlsession.getMapper(IEquipmentMapper.class);
        List<Equipment> all = mapper.getAll();
        return all;
    }

}

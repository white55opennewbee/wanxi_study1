package example.pc.dao;

import example.pc.Utils.ClassReflictionForDaoUtil;
import example.pc.Utils.Jdbc_Utils;
import example.pc.entity.Equipment;


import java.util.ArrayList;
import java.util.List;

public class EquitmentDao {


   public List<Equipment> getAll(){
       List list = new ArrayList();

       List<Object> entities = ClassReflictionForDaoUtil.getEntities(Equipment.class, Jdbc_Utils.getResultSet("select * from equipment"));
       for (Object o:entities){
           list.add((Equipment)o);
       }
       return list;
   }

}

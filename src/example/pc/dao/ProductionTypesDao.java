package example.pc.dao;

import example.pc.Utils.ClassReflictionForDaoUtil;
import example.pc.Utils.Jdbc_Utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductionTypesDao {

public List<String> getAllNewsTypes(){
    List<String> types = new ArrayList<>();
    types = ClassReflictionForDaoUtil.getEntities(String.class, Jdbc_Utils.getResultSet("select * from production_types where status = 1"));
//    ResultSet resultSet = Jdbc_Utils.getResultSet("select * from production_types where status = 1");

//    try {
//        if (!resultSet.isBeforeFirst()){
//            resultSet.beforeFirst();
//        }
//        while (resultSet.next()){
//            types.add(resultSet.getString("production_type"));
//        }
//    } catch (SQLException e) {
//        e.printStackTrace();
//    }
    return types;
}
}

package example.pc.dao;

import example.pc.Utils.ClassReflictionForDaoUtil;
import example.pc.Utils.Jdbc_Utils;
import example.pc.entity.User;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UserDao {


    public List<User> checkUser(String account,String password) {
        List<User> allEntity = null;
        String sql = "select * from user where account = ? and password = ?";
        PreparedStatement preparedStatement = Jdbc_Utils.getPreparedStatement(sql);
        try {
            preparedStatement.setString(1, account);
            preparedStatement.setString(2, password);
            allEntity = ClassReflictionForDaoUtil.getEntities(User.class, preparedStatement.executeQuery());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allEntity;
    }

//    public List<User> getAllShowableUsers(){
//        List<User> entities = ClassReflictionForDaoUtil.getEntities(User.class, Jdbc_Utils.getResultSet("select * from user where status = 1"));
//        return entities;
//    }
//
//
//    public List<User> getAllUsers(){
//        List<User> entities = ClassReflictionForDaoUtil.getEntities(User.class, Jdbc_Utils.getResultSet("select * from user"));
//        return entities;
//    }


    public void addUser(User user){
        String addSql = ClassReflictionForDaoUtil.insertSQL(user, "user");
        PreparedStatement preparedStatement = Jdbc_Utils.getPreparedStatement(addSql);
        try {
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUser(User user){
        ClassReflictionForDaoUtil.updateSQL(user,"update");
        String update = ClassReflictionForDaoUtil.updateSQL(user, "update");
        PreparedStatement preparedStatement = Jdbc_Utils.getPreparedStatement(update);
        try {
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(Integer id){
        User user = new User();
        user.setId(id);
        user.setStatus(0);
        updateUser(user);
    }

}

package example.pc.dao.impl;

import example.pc.Utils.ClassReflictionForDaoUtil;
import example.pc.Utils.Jdbc_Utils;
import example.pc.Utils.Mybatis_Utils;
import example.pc.dao.IUserMapper;
import example.pc.entity.User;
import org.apache.ibatis.session.SqlSession;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * @author pc
 * @date 2020/12/10
 *
 */
public class UserDao implements IUserMapper {

    @Override
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


    @Override
    public void addUser(User user){
        String addSql = ClassReflictionForDaoUtil.insertSQL(user, "user");
        PreparedStatement preparedStatement = Jdbc_Utils.getPreparedStatement(addSql);
        try {
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
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
    @Override
    public void deleteUser(Integer id){
        User user = new User();
        user.setId(id);
        user.setStatus(0);
        updateUser(user);

    }

    @Override
    public List<User> findAll() {
        SqlSession sqlsession = Mybatis_Utils.getSqlsession();
        IUserMapper mapper = sqlsession.getMapper(IUserMapper.class);
        List<User> all = mapper.findAll();
        return all;
    }

}

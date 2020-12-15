package example.pc.service.serviceImpl;

import example.pc.Utils.Mybatis_Utils;
import example.pc.dao.impl.UserDao;
import example.pc.dao.IUserMapper;
import example.pc.entity.User;
import example.pc.service.IUserService;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserServiceImpl implements IUserService {

    UserDao userDao = new UserDao();


    public Boolean checkUser(String account,String passowrd){

        List<User> users = userDao.checkUser(account, passowrd);
        if (users!=null&&users.size()>0){
            for (Object user:users){
                System.out.println(user.toString());
            }
            return true;
        }else {
            return false;
        }
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }


}

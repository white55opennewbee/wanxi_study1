package example.pc.dao;

import example.pc.entity.User;

import java.util.List;

public interface IUserMapper {
     List<User> checkUser(String account, String password) ;
     void addUser(User user);
     void updateUser(User user);
     void deleteUser(Integer id);
     List<User> findAll();
}

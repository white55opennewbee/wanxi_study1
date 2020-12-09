package example.pc.service;

import example.pc.entity.User;

public interface IUserService {
    Boolean checkUser(String account,String passowrd);
    void addUser(User user);

    void deleteUser(int id);
}

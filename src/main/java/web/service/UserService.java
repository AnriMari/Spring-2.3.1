package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> getList();
    void addUser(User user);
    void deleteUser(Long id);
    User getUser(long id);
    void updateUser(User user);
}

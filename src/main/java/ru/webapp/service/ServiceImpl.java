package ru.webapp.service;

import org.springframework.stereotype.Component;
import ru.webapp.dao.UserDao;
import ru.webapp.model.User;

import java.util.List;

@Component
public class UserService {
    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> getUsers() {
        return userDao.getAllUsers();
    }

    public void saveUser(User user) {
        userDao.save(user);
    }

    public User getUser(Long id){
        return userDao.getUser(id);
    }

    public void update(Long id, User user) {
        userDao.update(id, user);
    }
}

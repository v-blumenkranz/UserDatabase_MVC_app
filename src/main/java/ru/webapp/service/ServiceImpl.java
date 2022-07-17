package ru.webapp.service;

import org.springframework.stereotype.Component;
import ru.webapp.dao.UserDao;
import ru.webapp.model.User;

import java.util.List;

@Component
public class ServiceImpl implements ServiceDao{
    private final UserDao userDaoImpl;

    public ServiceImpl(UserDao userDaoImpl) {
        this.userDaoImpl = userDaoImpl;
    }


    public List<User> getAll() {
        return userDaoImpl.getAll();
    }

    public void save(User user) {
        userDaoImpl.save(user);
    }

    public User getById(Long id){
        return userDaoImpl.getById(id);
    }

    public void update(Long id, User user) {
        userDaoImpl.update(id, user);
    }

    @Override
    public void delete(Long id) {
        userDaoImpl.delete(id);
    }
}

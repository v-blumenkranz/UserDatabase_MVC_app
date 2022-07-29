package ru.webapp.service;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.webapp.dao.UserDao;
import ru.webapp.model.User;

import java.util.List;

@Component
public class ServiceImpl implements ServiceDao{
    private final UserDao userDaoImpl;

    public ServiceImpl(UserDao userDaoImpl) {
        this.userDaoImpl = userDaoImpl;
    }


    @Transactional
    public List<User> getAll() {
        return userDaoImpl.getAll();
    }

    @Transactional
    public void save(User user) {
        userDaoImpl.save(user);
    }

    @Transactional
    public User getById(Long id){
        return userDaoImpl.getById(id);
    }

    @Transactional
    public void update(Long id, User user) {
        userDaoImpl.update(id, user);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        userDaoImpl.delete(id);
    }
}

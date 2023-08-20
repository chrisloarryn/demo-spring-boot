package com.chrisloarryn.demospringboot.service;

import com.chrisloarryn.demospringboot.dao.UserDao;
import com.chrisloarryn.demospringboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service // Spring will create an instance of this class and keep it in memory
public class UserService {

    private final UserDao userDao;

    @Autowired // Spring will inject an instance of UserDao into this constructor
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> getAllUsers() {
        return userDao.selectAllUsers();
    }

    public Optional<User> getUser(UUID id) {
        return userDao.selectUserByUserUid(id);
    }

    public int updateUser(User user) {
        Optional<User> optionalUser = getUser(user.getId());
        if (optionalUser.isPresent()) {
            return userDao.updateUser(user);
        }
        return -1;
    }

    public int removeUser(UUID id) {
        Optional<User> optionalUser = getUser(id);
        if (optionalUser.isPresent()) {
            return userDao.deleteUserByUserUid(id);
        }
        return -1;
    }

    public int insertUser(User user) {
        UUID uid = UUID.randomUUID();
        user.setUserUid(uid);
        return userDao.insertUser(UUID.randomUUID(), user);
    }
}

package com.chrisloarryn.demospringboot.service;

import com.chrisloarryn.demospringboot.dao.UserDao;
import com.chrisloarryn.demospringboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service // Spring will create an instance of this class and keep it in memory
public class UserService {

    private final UserDao userDao;

    @Autowired // Spring will inject an instance of UserDao into this constructor
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> getAllUsers(Optional<String> gender) {
        List<User> users = userDao.selectAllUsers();
        if (gender.isEmpty()) {
            return users;
        }
        try {
            User.Gender theGender = User.Gender.valueOf(gender.get().toUpperCase());
            return users.stream()
                    .filter(user -> user.getGender().equals(theGender))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new IllegalStateException("Invalid gender", e);
        }
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
        return userDao.insertUser(uid, User.newUser(uid, user));
    }
}

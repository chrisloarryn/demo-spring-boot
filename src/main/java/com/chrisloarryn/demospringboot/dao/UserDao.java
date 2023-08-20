package com.chrisloarryn.demospringboot.dao;

import com.chrisloarryn.demospringboot.model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserDao {
    List<User> selectAllUsers();

    Optional<User> selectUserByUserUid(UUID id);

    int updateUser(User user);

    int deleteUserByUserUid(UUID id);

    int insertUser(UUID userUid, User user);
}

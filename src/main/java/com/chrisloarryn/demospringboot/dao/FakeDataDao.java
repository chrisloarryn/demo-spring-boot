package com.chrisloarryn.demospringboot.dao;

import com.chrisloarryn.demospringboot.model.User;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class FakeDataDao implements UserDao {

    // fake database
    private Map<UUID, User> database;

    public FakeDataDao() {
        database = new HashMap<>();
        UUID joeUserUid = UUID.randomUUID();
        database.put(joeUserUid, new User(
                        joeUserUid,
                        "Joe",
                        "Jones",
                        User.Gender.Male,
                        27,
                        "chrisloarryn@gmail.com"
                )
        );
    }

    @Override
    public List<User> selectAllUsers() {
        return new ArrayList<>(database.values());
    }

    @Override
    public Optional<User> selectUserByUserUid(UUID id) {
        return Optional.ofNullable(database.get(id));
    }

    @Override
    public int updateUser(User user) {
        // if user is updated return 1, else return -1
        return database.put(user.getId(), user) == null ? -1 : 1;
    }

    @Override
    public int deleteUserByUserUid(UUID id) {
        // if user is deleted return 1, else return -1
        return database.remove(id) == null ? -1 : 1;
    }

    @Override
    public int insertUser(UUID userUid, User user) {
        // if user is updated return 1, else return -1
        return database.put(userUid, user) == null ? 1 : -1;
    }
}

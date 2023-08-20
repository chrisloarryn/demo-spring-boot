package com.chrisloarryn.demospringboot.dao;

import com.chrisloarryn.demospringboot.model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat; // import assertThat from AssertJ

class FakeDataDaoTest {

    private FakeDataDao fakeDataDao;

    @BeforeEach
    void setUp() {
        fakeDataDao = new FakeDataDao();
    }

    @AfterEach
    void tearDown() {
        fakeDataDao = null;
    }

    @Test
    void selectAllUsers() {
        List<User> users = fakeDataDao.selectAllUsers();
        assertThat(users).hasSize(1);
        User user = users.get(0);
        assertThat(user.getAge()).isEqualTo(27);
        assertThat(user.getFirstName()).isEqualTo("Joe");
        assertThat(user.getLastName()).isEqualTo("Jones");
        assertThat(user.getGender()).isEqualTo(User.Gender.MALE);
        assertThat(user.getEmail()).isEqualTo("chrisloarryn@gmail.com");
        assertThat(user.getId()).isNotNull();
        assertThat(user.getId()).isInstanceOf(java.util.UUID.class);
    }

    @Test
    void shouldSelectUserByUserUid() {
        UUID annaUserUid = UUID.randomUUID();
        User user = new User(
                annaUserUid,
                "Anna",
                "Montana",
                User.Gender.FEMALE,
                30,
                "anna.montana@gmail.com"
        );
        fakeDataDao.insertUser(annaUserUid, user);

        assertThat(fakeDataDao.selectAllUsers()).hasSize(2);
        assertThat(fakeDataDao.selectUserByUserUid(annaUserUid)).isPresent();

        Optional<User> anna = fakeDataDao.selectUserByUserUid(annaUserUid);
        assertThat(anna.isPresent()).isTrue();
        assertThat(anna.get()).isInstanceOf(User.class);
    }

    @Test
    void shouldNotSelectUserByUserUid() {
        Optional<User> user = fakeDataDao.selectUserByUserUid(UUID.randomUUID());
        assertThat(user.isPresent()).isFalse();
    }

    @Test
    void updateUser() {
        UUID joeUserUid = fakeDataDao.selectAllUsers().get(0).getId();
        assertThat(joeUserUid).isNotNull();
        assertThat(joeUserUid).isInstanceOf(UUID.class);

        User newJoe = new User(
                joeUserUid,
                "Anna",
                "Montana",
                User.Gender.FEMALE,
                30,
                "anna.montana@gmail.com"
        );

        fakeDataDao.updateUser(newJoe);
        Optional<User> user = fakeDataDao.selectUserByUserUid(joeUserUid);
        assertThat(user.isPresent()).isTrue();

        assertThat(fakeDataDao.selectAllUsers()).hasSize(1);

        assertThat(user.get().getFirstName()).isEqualTo("Anna");
        assertThat(user.get().getLastName()).isEqualTo("Montana");
        assertThat(user.get().getGender()).isEqualTo(User.Gender.FEMALE);
        assertThat(user.get().getAge()).isEqualTo(30);
        assertThat(user.get().getEmail()).isEqualTo("anna.montana@gmail.com");
    }

    @Test
    void shouldNoUpdateUserNotFound() {
        int expectedError = -1;
        User joe = fakeDataDao.selectAllUsers().get(0);
        fakeDataDao.deleteUserByUserUid(joe.getId());
        int response = fakeDataDao.updateUser(joe);
        assertThat(response).isEqualTo(expectedError);
    }

    @Test
    void deleteUserByUserUid() {
        UUID joeUserUid = fakeDataDao.selectAllUsers().get(0).getId();
        assertThat(fakeDataDao.selectAllUsers()).hasSize(1);

        fakeDataDao.deleteUserByUserUid(joeUserUid);

        assertThat(fakeDataDao.selectAllUsers()).isEmpty();
        assertThat(fakeDataDao.selectUserByUserUid(joeUserUid).isPresent()).isFalse();
    }

    @Test
    void insertUser() {
        UUID userUid = UUID.randomUUID();
        User user = new User(
                userUid,
                "Anna",
                "Montana",
                User.Gender.FEMALE,
                30,
                "anna.montana@gmail.com"
        );

        fakeDataDao.insertUser(userUid, user);

        List<User> users = fakeDataDao.selectAllUsers();
        assertThat(users).hasSize(2);
        assertThat(fakeDataDao.selectUserByUserUid(userUid).get().getFirstName()).isEqualTo("Anna");
        assertThat(fakeDataDao.selectUserByUserUid(userUid).get().getLastName()).isEqualTo("Montana");
    }
}
package com.chrisloarryn.demospringboot.service;

import com.chrisloarryn.demospringboot.dao.FakeDataDao;
import com.chrisloarryn.demospringboot.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

class UserServiceTest {

    @Mock
    private FakeDataDao fakeDataDao;
    private UserService userService;

    @BeforeEach
    void setUp() {
        fakeDataDao = mock(FakeDataDao.class);
        userService = new UserService(fakeDataDao);
    }

    @Test
    void getAllUsers() {
        UUID annaUid = UUID.randomUUID();
        User anna = new User(
                annaUid,
                "Anna",
                "Banana",
                User.Gender.FEMALE,
                30,
                "example@email.com"
        );

        // mock the selectAllUsers() method of the fakeDataDao object
        List<User> users = Collections.singletonList(anna);
        given(fakeDataDao.selectAllUsers()).willReturn(users);

        // TODO: refactor to use BDDMockito
        List<User> allUsers = userService.getAllUsers(Optional.empty());

        verify(fakeDataDao, times(1)).selectAllUsers();
        assertThat(allUsers).hasSize(1);
        assertAnnaUserFields(users.get(0));
    }



    @Test
    public void shouldGetAllUsersByGender() {
        UUID annaUid = UUID.randomUUID();
        UUID joeUid = UUID.randomUUID();

        User anna = new User(
                annaUid,
                "Anna",
                "Banana",
                User.Gender.FEMALE,
                30,
                "anna@email.com"
        );

        User joe = new User(
                joeUid,
                "Joe",
                "Jones",
                User.Gender.MALE,
                30,
                "joe@email.com"
        );

        // mock the selectAllUsers() method of the fakeDataDao object
        List<User> users = List.of(anna, joe);
        given(fakeDataDao.selectAllUsers()).willReturn(users);

        List<User> filteredUsers = userService.getAllUsers(Optional.of(User.Gender.FEMALE.name()));
        assertThat(filteredUsers).hasSize(1);
    }

    @Test
    public void shouldThrowExceptionWhenGenderIsInvalid() {
        assertThatThrownBy(() -> userService.getAllUsers(Optional.of("Peluca")))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("Invalid gender");
    }

    @Test
    void shouldGetUser() {
        UUID uid = UUID.randomUUID();
        User newUser = new User(uid, "Anna", "Banana", User.Gender.FEMALE, 30, "example@email.com");

        given(fakeDataDao.selectUserByUserUid(uid)).willReturn(Optional.of(newUser));

        Optional<User> createdUser = userService.getUser(uid);

        verify(fakeDataDao, times(1)).selectUserByUserUid(uid);
        assertThat(createdUser).isPresent();
        assertAnnaUserFields(createdUser.get());
    }

    @Test
    void shouldNotGetUser() {
        UUID uid = UUID.randomUUID();
        Optional<User> user = userService.getUser(uid);

        given(fakeDataDao.selectUserByUserUid(uid)).willReturn(user);

        assertThat(user).isNotPresent();
        assertThat(userService.getUser(uid)).isNotPresent();
    }

    @Test
    void shouldUpdateUser() {
        UUID uid = UUID.randomUUID();
        User user = new User(uid, "Anna","Banana", User.Gender.FEMALE, 30, "example@email.com");

        given(fakeDataDao.selectUserByUserUid(uid)).willReturn(Optional.of(user));
        given(fakeDataDao.updateUser(user)).willReturn(1);

        ArgumentCaptor<User> captor = ArgumentCaptor.forClass(User.class);

        int updateResult = userService.updateUser(user);

        verify(fakeDataDao, times(1)).selectUserByUserUid(uid);
        verify(fakeDataDao).updateUser(captor.capture());

        User userArgument = captor.getValue();
        assertAnnaUserFields(userArgument);

        assertThat(updateResult).isEqualTo(1);
    }

    @Test
    void shouldNotUpdateUser() {
        UUID uid = UUID.randomUUID();
        User user = new User(uid, "Anna","Banana", User.Gender.MALE, 18, "example@email.com");

        int status = userService.updateUser(user);

        verify(fakeDataDao, times(0)).updateUser(user);
        assertThat(status).isEqualTo(-1);
    }

    @Test
    void shouldNotRemoveUser() {
        UUID uid = UUID.randomUUID();

        given(fakeDataDao.selectUserByUserUid(uid)).willReturn(Optional.empty());

        int status = userService.removeUser(uid);

        verify(fakeDataDao, times(1)).selectUserByUserUid(uid);
        assertThat(status).isEqualTo(-1);
    }

    @Test
    void shouldRemoveUser() {
        UUID uid = UUID.randomUUID();
        User user = new User(uid, "Anna","Banana", User.Gender.FEMALE, 30, "example@email.com");

        given(fakeDataDao.selectUserByUserUid(uid)).willReturn(Optional.of(user));
        given(fakeDataDao.deleteUserByUserUid(uid)).willReturn(1);

        int deleteResult = userService.removeUser(uid);

        verify(fakeDataDao, times(1)).selectUserByUserUid(uid);
        verify(fakeDataDao, times(1)).deleteUserByUserUid(uid);

        assertThat(deleteResult).isEqualTo(1);
    }

    @Test
    void shouldInsertUser() {
        User user = new User(null, "Anna","Banana", User.Gender.FEMALE, 30, "example@email.com");

        given(fakeDataDao.insertUser(any(UUID.class), eq(user))).willReturn(1);

        ArgumentCaptor<User> captor = ArgumentCaptor.forClass(User.class);

        int insertResult = userService.insertUser(user);

        verify(fakeDataDao, times(1)).insertUser(any(UUID.class), captor.capture());

        User userArgument = captor.getValue();

        assertAnnaUserFields(userArgument);
        assertThat(insertResult).isEqualTo(1);
    }

    private void assertAnnaUserFields(User user) {
        assertThat(user.getFirstName()).isEqualTo("Anna");
        assertThat(user.getLastName()).isEqualTo("Banana");
        assertThat(user.getEmail()).isEqualTo("example@email.com");
        assertThat(user.getGender()).isEqualTo(User.Gender.FEMALE);
        assertThat(user.getAge()).isEqualTo(30);
        assertThat(user.getId()).isNotNull();
    }
}
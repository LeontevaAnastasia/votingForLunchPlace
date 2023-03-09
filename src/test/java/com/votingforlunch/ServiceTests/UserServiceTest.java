package com.votingforlunch.ServiceTests;

import com.votingforlunch.UserTestData;
import com.votingforlunch.model.Role;
import com.votingforlunch.service.UserService;
import com.votingforlunch.to.UserTo;
import com.votingforlunch.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.dao.DataAccessException;
import com.votingforlunch.model.User;

import java.util.List;

import static com.votingforlunch.UserTestData.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserServiceTest extends AbstractServiceTest {

    @Autowired
    private UserService userService;


    @Test
       void create() {
        User created = userService.create(getNew());
        Integer newId = created.getId();
        User newUser = getNew();
        newUser.setId(newId);
        USER_MATCHER.assertMatch(created, newUser);
          USER_MATCHER.assertMatch(userService.get(newId), newUser);
    }

        @Test
        void delete() {
        userService.delete(UserTestData.USER_ID1);
        Assertions.assertThrows(NotFoundException.class, () -> userService.get(UserTestData.USER_ID1));
    }

    @Test
    void get() {
        User user = userService.get(USER_ID1);
        USER_MATCHER.assertMatch(user, userOne);
    }

    @Test
    void getNotFound() {
        Assertions.assertThrows(NotFoundException.class, () -> userService.get(NOT_FOUND));
    }


    @Test
        void getAll() {
        List<User> all = userService.getAll();
        USER_MATCHER.assertMatch(all, userOne,userTwo,admin);
    }

    @Test
        void getByEmail() {
        User user = userService.findByEmailIgnoringCase("admin@gmail.com").orElse(null);
        USER_MATCHER.assertMatch(user, admin);
    }

    @Test
        void duplicateMailCreate() {
        assertThrows(DataAccessException.class, () ->
                userService.create(new User(null, "Duplicate", "user1@gmail.com", "newPass", Role.USER)));
    }

    @Test
        void update() {
        User updated = UserTestData.getUpdated();
        userService.update(updated);
        UserTestData.USER_MATCHER.assertMatch(userService.get(UserTestData.USER_ID1), getUpdated());
    }

    @Test
        void updateUserTo() {
        UserTo updated = UserTestData.getUpdatedTo();
        userService.update(updated);
        UserTestData.USER_MATCHER.assertMatch(userService.get(UserTestData.USER_ID1), UserTestData.userOneUpdFromTo);
    }



}

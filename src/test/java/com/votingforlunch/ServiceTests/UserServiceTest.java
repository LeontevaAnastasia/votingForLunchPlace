package com.votingforlunch.ServiceTests;

import com.votingforlunch.UserTestData;
import com.votingforlunch.model.Role;
import com.votingforlunch.service.UserService;
import com.votingforlunch.to.UserTo;
import org.hibernate.LazyInitializationException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.junit4.SpringRunner;
import com.votingforlunch.model.User;

import java.util.List;

import static com.votingforlunch.UserTestData.*;
import static org.junit.Assert.assertThrows;

@SpringBootTest
@RunWith(SpringRunner.class)

public class UserServiceTest extends AbstractServiceTest {

    @Autowired
    private UserService userService;


    @Test (expected = LazyInitializationException.class)
    public void create() {
        User created = userService.create(getNew());
        Integer newId = created.getId();
        User newUser = getNew();
        newUser.setId(newId);
        USER_MATCHER.assertMatch(created, newUser);
        USER_MATCHER.assertMatch(userService.get(newId), newUser);
    }

      @Test
    public void delete() {
        userService.delete(UserTestData.USER_ID1);
          Assert.assertNull(userService.get(UserTestData.USER_ID1));
    }

    @Test(expected = LazyInitializationException.class)
    public void get() {
        User user = userService.get(USER_ID1);
        USER_MATCHER.assertMatch(user, userOne);
    }

    @Test(expected = LazyInitializationException.class)
    public void getNotFound() {
        Assert.assertNull(userService.get(NOT_FOUND));
    }


    @Test
    public void getAll() {
        List<User> all = userService.getAll();
        USER_MATCHER.assertMatch(all, userOne,userTwo,admin);
    }

    @Test
    public void getByEmail() {
        User user = userService.findByEmailIgnoringCase("admin@gmail.com").orElse(null);
        USER_MATCHER.assertMatch(user, admin);
    }

    @Test
    public void duplicateMailCreate() {
        assertThrows(DataAccessException.class, () ->
                userService.create(new User(null, "Duplicate", "user1@gmail.com", "newPass", Role.USER)));
    }

    @Test(expected = LazyInitializationException.class)
    public void update() {
        User updated = getUpdated();
        userService.update(updated);
        USER_MATCHER.assertMatch(userService.get(USER_ID1), getUpdated());
    }

    @Test(expected = LazyInitializationException.class)
   public void updateUserTo() {
        UserTo updated = UserTestData.getUpdatedTo();
        userService.update(updated);
        UserTestData.USER_MATCHER.assertMatch(userService.get(UserTestData.USER_ID1), UserTestData.userOneUpdFromTo);
    }

}

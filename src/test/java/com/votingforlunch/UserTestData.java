package com.votingforlunch;

import com.votingforlunch.model.Role;
import com.votingforlunch.model.User;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;



public class UserTestData {

    public static final int USER_ID1 = 1;
    public static final int USER_ID2 = 2;
    public static final int ADMIN_ID = 3;
    public static final int NOT_FOUND = 10;

    public static final MatcherFactory.Matcher<User> USER_MATCHER = MatcherFactory.usingIgnoringFieldsComparator(User.class, "registered");


    public static final User userOne = new User(USER_ID1, "User1", "user1@gmail.com", "password", LocalDate.now(), true, Set.of(Role.ROLE_USER));
    public static final User userTwo = new User(USER_ID2, "User2", "user2@gmail.com", "password", LocalDate.now(), true, Set.of(Role.ROLE_USER));
    public static final User admin = new User(ADMIN_ID, "Admin", "admin@gmail.com", "admin", LocalDate.now(), true, Set.of(Role.ROLE_ADMIN));



    public static User getNew() {
        return new User(null, "New", "new@gmail.com", "newPass", LocalDate.now(), false, Collections.singleton(Role.ROLE_USER));
    }


    public static User getUpdated() {
        User updated = new User(userOne);
        updated.setEmail("update@gmail.com");
        updated.setName("UpdatedName");
        updated.setPassword("updatedPass");
        updated.setEnabled(false);
        updated.setRoles(Set.of(Role.ROLE_ADMIN));
        return updated;
    }
}

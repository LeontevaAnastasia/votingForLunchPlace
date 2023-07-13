package com.votingforlunch.util;

import com.votingforlunch.model.Role;
import com.votingforlunch.model.User;
import com.votingforlunch.to.UserTo;
import lombok.experimental.UtilityClass;

import java.time.LocalDate;
import java.util.Set;

@UtilityClass
public class UserUtil {

    public static User updateFromTo(User user, UserTo userTo) {
        user.setName(userTo.getName());
        user.setEmail(userTo.getEmail().toLowerCase());
        user.setPassword(userTo.getPassword());
        return user;
    }


    public static User createNewFromTo(UserTo userTo) {
        Set<Role> roleSet = Set.of(Role.USER);
        return new User(null, userTo.getName(), userTo.getEmail().toLowerCase(), userTo.getPassword(), LocalDate.now(), true, roleSet);
    }

}

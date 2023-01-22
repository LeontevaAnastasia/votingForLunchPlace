package com.votingforlunch.util;

import com.votingforlunch.model.User;

import static com.votingforlunch.config.WebSecurityConfig.PASSWORD_ENCODER;

public class UserUtil {

    public static User prepareToSave(User user) {
        user.setPassword(PASSWORD_ENCODER.encode(user.getPassword()));
        user.setEmail(user.getEmail().toLowerCase());
        return user;
    }
}

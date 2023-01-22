package com.votingforlunch;

import com.votingforlunch.model.User;
import com.votingforlunch.to.UserTo;
import com.votingforlunch.util.UserUtil;
import lombok.Getter;
import lombok.ToString;

import java.io.Serial;

@Getter
@ToString
public class AuthUser extends org.springframework.security.core.userdetails.User {

    @Serial
    private static final long serialVersionUID = 1L;

    private UserTo userTo;

    public AuthUser(User user) {
        super(user.getEmail(), user.getPassword(), user.isEnabled(), true, true, true, user.getRoles());
        this.userTo = UserUtil.asTo(user);
    }

    public int getId() {
        return userTo.id();
    }

    public void update(UserTo newTo) {
        userTo = newTo;
    }

    public UserTo getUserTo() {
        return userTo;
    }
}

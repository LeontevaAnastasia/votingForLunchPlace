package com.votingforlunch.web.user;

import com.votingforlunch.model.User;
import com.votingforlunch.web.user.AbstractUserController;
import org.springframework.stereotype.Controller;

import static com.votingforlunch.web.SecurityUtil.authUserId;

@Controller
public class ProfileRestController extends AbstractUserController {

    public User get() {
        return super.get(authUserId());
    }

    public void delete() {
        super.delete(authUserId());
    }

    public void update(User user) {
        super.update(user, authUserId());
    }
}

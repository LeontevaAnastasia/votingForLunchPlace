package com.votingforlunch.web.user;
import com.votingforlunch.model.User;
import com.votingforlunch.web.user.AbstractUserController;

import java.util.List;

public class AdminRestController extends AbstractUserController {

    @Override
    public List<User> getAll() {
        return super.getAll();
    }

    @Override
    public User get(int id) {
        return super.get(id);
    }

    @Override
    public User create(User user) {
        return super.create(user);
    }

    @Override
    public void update(User user, int id) {
        super.update(user, id);
    }

}
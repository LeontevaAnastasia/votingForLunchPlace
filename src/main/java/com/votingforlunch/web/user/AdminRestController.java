package com.votingforlunch.web.user;
import com.votingforlunch.model.User;
import com.votingforlunch.web.user.AbstractUserController;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
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

    public void delete(int id){

        super.delete(id);
    }

    public User findByEmailIgnoringCase(String email){
        return super.findByEmailIgnoringCase(email);
    }

}
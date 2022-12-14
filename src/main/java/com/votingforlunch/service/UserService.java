package com.votingforlunch.service;

import com.votingforlunch.model.User;
import com.votingforlunch.repository.UserRepository;
import com.votingforlunch.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

import static com.votingforlunch.util.ValidationUtil.checkNotFoundWithId;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User create(User user) {
        Assert.notNull(user, "user must not be null");
        return repository.save(user);
    }


    public User get(int id) {
        return checkNotFoundWithId(repository.getReferenceById(id), id);
    }

    public User findByEmailIgnoringCase(String email){
        Assert.notNull(email, "email must not be null");
        return ValidationUtil.checkNotFound(repository.findByEmailIgnoreCase(email), "email=" + email);

    }

    public void delete(int id) {

        checkNotFoundWithId(repository.delete(id),id);
    }

    public List<User> getAll() {
        return repository.findAll();
    }

    public void update(User user) {
        Assert.notNull(user, "user must not be null");
        checkNotFoundWithId(repository.save(user), user.getId());
    }
}

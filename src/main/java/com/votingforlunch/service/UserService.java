package com.votingforlunch.service;

import com.votingforlunch.model.User;
import com.votingforlunch.repository.UserRepository;

import java.util.List;

import static com.votingforlunch.util.ValidationUtil.checkNotFound;
import static com.votingforlunch.util.ValidationUtil.checkNotFoundWithId;

public class UserService {
    private UserRepository repository;

    public User create(User user) {
        return repository.save(user);
    }


    public User get(int id) {
        return checkNotFoundWithId(repository.getReferenceById(id), id);
    }


    public List<User> getAll() {
        return repository.findAll();
    }

    public void update(User user) {
        checkNotFoundWithId(repository.save(user), user.getId());
    }
}

package com.votingforlunch.service;

import com.votingforlunch.model.User;
import com.votingforlunch.repository.UserRepository;
import com.votingforlunch.util.ValidationUtil;
import com.votingforlunch.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

import static com.votingforlunch.util.ValidationUtil.checkNotFoundWithId;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User create(User user) {
        Assert.notNull(user, "user must not be null");
        return userRepository.save(user);
    }


    public User get(int id) {
        return checkNotFoundWithId(userRepository.getReferenceById(id), id);
    }

    public User findByEmailIgnoringCase(String email){
        Assert.notNull(email, "email must not be null");
        return ValidationUtil.checkNotFound(userRepository.findByEmailIgnoreCase(email), "email=" + email);

    }

    public void delete(int id) {

        checkNotFoundWithId(userRepository.delete(id),id);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public void update(User user) {
        Assert.notNull(user, "user must not be null");
        checkNotFoundWithId(userRepository.save(user), user.getId());
    }

    @Transactional
    public void isEnable(int id, boolean enabled) {
        User user = userRepository.getById(id).orElse(null);
        if (user == null) {
            throw new NotFoundException("User with id " + id + " doesn't exists.");
        }
        user.setEnabled(enabled);
    }
}

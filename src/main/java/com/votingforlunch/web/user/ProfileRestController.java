package com.votingforlunch.web.user;

import com.votingforlunch.model.User;
import com.votingforlunch.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

import static com.votingforlunch.util.ValidationUtil.assureIdConsistent;
import static com.votingforlunch.util.SecurityUtil.authUserId;

@RestController
@RequestMapping(value="/rest/profile", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProfileRestController{

    private final UserService userService;

    public ProfileRestController(UserService userService) {
        this.userService = userService;
    }
    protected final Logger log = LoggerFactory.getLogger(getClass());



    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<User> register(@Valid @RequestBody User user) {
        log.info("Create new user from to {}", user);
        User created = userService.create(user);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/rest/profile/{id}")
                .buildAndExpand(created.getId())
                .toUri();
        return ResponseEntity.created(uriOfNewResource).body(created);
    }


    @GetMapping()
    public User get(User user) {
        log.info("Get userTo by id {}.", user.getId());
        return userService.get(user.getId());
    }


    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(User user) {
        log.info("Delete profile id {} by user.", user.getId());
        userService.delete(user.getId());
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@Valid @RequestBody User user) {
        log.info("Update user to {} by user id {}.", user, user.getId());
        assureIdConsistent(user, authUserId());
        userService.update(user);
    }
}

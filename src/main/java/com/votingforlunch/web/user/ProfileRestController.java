package com.votingforlunch.web.user;

import com.votingforlunch.AuthUser;
import com.votingforlunch.model.User;
import com.votingforlunch.service.UserService;
import com.votingforlunch.to.UserTo;
import com.votingforlunch.util.UserUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

import static com.votingforlunch.util.ValidationUtil.assureIdConsistent;

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
    public ResponseEntity<User> register(@Valid @RequestBody UserTo userTo) {
        log.info("Create new user from to {}", userTo);
        User created = userService.create(UserUtil.createNewFromTo(userTo));
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/rest/profile/{id}")
                .buildAndExpand(created.getId())
                .toUri();
        return ResponseEntity.created(uriOfNewResource).body(created);
    }


    @GetMapping()
    public UserTo get(@AuthenticationPrincipal AuthUser authUser) {
        log.info("Get userTo by id {}.", authUser.getId());
        return UserUtil.asTo(userService.get(authUser.getId()));
    }


    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@AuthenticationPrincipal User user) {
        log.info("Delete profile id {} by user.", user.getId());
        userService.delete(user.getId());
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@Valid @RequestBody UserTo userTo, @AuthenticationPrincipal AuthUser authUser) {
        log.info("Update user to {} by user id {}.", userTo, authUser.getId());
        UserTo oldUser = authUser.getUserTo();
        assureIdConsistent(userTo, oldUser.id());
      //  userTo.setRoles(oldUser.getRoles());
        if (userTo.getPassword() == null) {
            userTo.setPassword(oldUser.getPassword());
        }
        userService.update(userTo);
    }
}

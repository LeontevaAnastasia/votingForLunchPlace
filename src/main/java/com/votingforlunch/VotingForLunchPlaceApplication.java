package com.votingforlunch;

import com.votingforlunch.model.Role;
import com.votingforlunch.model.User;
import com.votingforlunch.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Set;

@SpringBootApplication
@AllArgsConstructor
public class VotingForLunchPlaceApplication implements ApplicationRunner {
    private final UserRepository userRepository;


    public static void main(String[] args) {
        SpringApplication.run(VotingForLunchPlaceApplication.class, args);
        System.out.println();
    }

    @Override
    public void run(ApplicationArguments args) {
        userRepository.save(new User("User_First", "user@gmail.com", "password", LocalDate.now(), true, Set.of(Role.ROLE_USER)));
        userRepository.save(new User("Admin_First", "admin@javaops.ru",  "admin", LocalDate.now(), true,Set.of(Role.ROLE_USER, Role.ROLE_ADMIN)));
        System.out.println(userRepository.findAll());
    }
}

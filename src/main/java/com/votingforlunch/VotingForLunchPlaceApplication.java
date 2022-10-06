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

    }

    @Override
    public void run(ApplicationArguments args) {
           System.out.println(userRepository.findAll());
    }
}

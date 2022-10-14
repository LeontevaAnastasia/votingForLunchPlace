package com.votingforlunch.repository;

import com.votingforlunch.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("SELECT u FROM User u WHERE u.email = LOWER(:email)")
    User findByEmailIgnoreCase(String email);

    @Query("delete from User u where u.id=:id")
    boolean delete(@Param("id") int id);

}

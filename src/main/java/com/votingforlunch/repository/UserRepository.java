package com.votingforlunch.repository;

import com.votingforlunch.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("SELECT u FROM User u WHERE u.email = LOWER(:email)")
    User findByEmailIgnoreCase(String email);


    @Modifying
    @Transactional
    @Query("delete from User u where u.id=:id")
    int delete(@Param("id") int id);

}

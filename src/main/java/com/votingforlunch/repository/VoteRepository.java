package com.votingforlunch.repository;
import com.votingforlunch.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface VoteRepository extends JpaRepository<Vote, Integer> {

    @Modifying
    @Transactional
    @Query("delete from Vote v where v.id=:id and v.userId=:userId")
    int delete(@Param("id")int id, @Param("userId") int userId);

    @Query("select v from Vote v where v.id=:id and v.userId=:userId")
    Vote findById(@Param("id") int id,@Param("userId") int userId);

    @Query("select v from Vote v where v.userId=:userId and v.date=:date")
    Optional<Vote> getByUserIdAndDate(@Param("userId") int userId, @Param("date") LocalDate date);




}

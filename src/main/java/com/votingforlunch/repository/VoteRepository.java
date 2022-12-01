package com.votingforlunch.repository;
import com.votingforlunch.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface VoteRepository extends JpaRepository<Vote, Integer> {

    @Query("delete from Vote v where v.id=:id and v.userId=:userId")
    int delete(@Param("id")int id, @Param("userId") int userId);

    @Query("select v from Vote v where v.id=:id and v.userId=:userId")
    Vote findById(@Param("id") int id,@Param("userId") int userId);

    @Query("select v from Vote v where v.userId=:userId and v.date=:date")
    Vote getByUserIdAndTime(@Param("userId") int userId);




}

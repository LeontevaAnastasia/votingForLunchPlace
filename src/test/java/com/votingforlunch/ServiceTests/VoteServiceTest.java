package com.votingforlunch.ServiceTests;


import com.votingforlunch.UserTestData;
import com.votingforlunch.VoteTestData;
import com.votingforlunch.model.Vote;
import com.votingforlunch.service.VoteService;
import com.votingforlunch.to.VoteTo;
import com.votingforlunch.util.exception.DuplVoteException;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import java.time.LocalTime;
import static com.votingforlunch.VoteTestData.VOTE_MATCHER;
import static com.votingforlunch.VoteTestData.createNewFromTo;

@SpringBootTest
public class VoteServiceTest extends AbstractServiceTest{


    @Autowired
    VoteService voteService;


    @Test
    public void get(){
        Vote actual = voteService.get(VoteTestData.VOTE_USER1_ID, UserTestData.USER_ID1);
        VOTE_MATCHER.assertMatch(actual, VoteTestData.VOTE1);
    }



    @Test
    public void updateAfter11Am() {
        VoteTo updated = VoteTestData.getUpdated();
        Assertions.assertThrows(DuplVoteException.class, () -> voteService.createOrUpdateForTest(updated, UserTestData.USER_ID1, LocalTime.of(11,5)));
    }

    @Test
   public void updateBefore11Am() {
        VoteTo testUpdated = VoteTestData.getUpdated();
        Vote updated = voteService.createOrUpdateForTest(testUpdated, UserTestData.USER_ID1, LocalTime.of(9, 0));
        VoteTestData.VOTE_MATCHER.assertMatch(voteService.get(1, UserTestData.USER_ID1), updated);
    }

    @Test
    public void create() {
         voteService.delete(VoteTestData.VOTE_USER1_ID, UserTestData.USER_ID1);
        Vote created = voteService.createOrUpdate(VoteTestData.getNew(), UserTestData.USER_ID1);
        int newId = created.id();
        Vote newVote = createNewFromTo(VoteTestData.getNew(), UserTestData.USER_ID1);
        newVote.setId(newId);
        VoteTestData.VOTE_MATCHER.assertMatch(created, newVote);
        VoteTestData.VOTE_MATCHER.assertMatch(voteService.get(newId, UserTestData.USER_ID1), newVote);
    }

}

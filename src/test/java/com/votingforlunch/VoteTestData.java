package com.votingforlunch;

import com.votingforlunch.model.Vote;
import com.votingforlunch.repository.RestaurantRepository;
import com.votingforlunch.repository.VoteRepository;
import com.votingforlunch.to.VoteTo;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

public class VoteTestData {
    public static final MatcherFactory.Matcher<Vote> VOTE_MATCHER = MatcherFactory.usingIgnoringFieldsComparator();

    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    VoteRepository voteRepository;

    public static final int VOTE_USER1_ID = 1;

    public static final Vote VOTE1 = new Vote(1, LocalDate.now(), UserTestData.USER_ID1, 1);
    public static final Vote VOTE2= new Vote(2, LocalDate.now(), UserTestData.USER_ID2, 2);
    public static final Vote VOTE3 = new Vote(3, LocalDate.now(), UserTestData.ADMIN_ID, 1);

    public static VoteTo getNew() {
        return new VoteTo(4);
    }

    public static VoteTo getUpdated() { return new VoteTo(2);}


}

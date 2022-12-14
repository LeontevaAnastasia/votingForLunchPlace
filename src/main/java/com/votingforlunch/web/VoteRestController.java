package com.votingforlunch.web;

import com.votingforlunch.model.Vote;
import com.votingforlunch.service.VoteService;
import com.votingforlunch.to.VoteTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class VoteRestController {

    @Autowired
    VoteService voteService;

    public Vote create (Vote vote, int userId){
       return voteService.createOrUpdate(vote,userId);

    }
}

package com.votingforlunch.web;

import com.votingforlunch.model.Vote;
import com.votingforlunch.service.VoteService;
import com.votingforlunch.to.VoteTo;
import org.springframework.stereotype.Controller;

@Controller
public class VoteRestController {

    VoteService voteService;

    public Vote create (VoteTo voteTo, int userId){
       return voteService.createOrUpdate(voteTo,userId);

    }
}

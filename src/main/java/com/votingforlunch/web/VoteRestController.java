package com.votingforlunch.web;

import com.votingforlunch.model.Vote;
import com.votingforlunch.service.VoteService;

public class VoteRestController {

    VoteService voteService;

    public Vote create (Vote vote){
       return voteService.create(vote);

    }
}

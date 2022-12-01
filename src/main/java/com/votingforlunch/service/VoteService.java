package com.votingforlunch.service;

import com.votingforlunch.model.Dish;
import com.votingforlunch.model.Vote;
import com.votingforlunch.repository.VoteRepository;
import com.votingforlunch.util.ValidationUtil;

import java.util.List;

import static com.votingforlunch.util.ValidationUtil.checkNotFoundWithId;

public class VoteService {
    VoteRepository voteRepository;

    public Vote create(Vote vote) {
        return voteRepository.save(vote);
    }

    public Vote get(int id, int userId) {
        return checkNotFoundWithId(voteRepository.findById(id, userId), id);
    }

    public List<Vote> getAll() {
        return voteRepository.findAll();
    }

    public void delete(int id, int userId) {
        checkNotFoundWithId(voteRepository.delete(id, userId), id);
    }




}

package com.votingforlunch.service;

import com.votingforlunch.model.Vote;
import com.votingforlunch.repository.RestaurantRepository;
import com.votingforlunch.repository.VoteRepository;
import com.votingforlunch.to.VoteTo;
import com.votingforlunch.util.ValidationUtil;
import com.votingforlunch.util.exception.DuplVoteException;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static com.votingforlunch.util.ValidationUtil.checkNotFoundWithId;
import static org.slf4j.LoggerFactory.getLogger;

@Service
public class VoteService {
    @Autowired
    VoteRepository voteRepository;

    @Autowired
    RestaurantRepository restaurantRepository;

    private static final Logger log = getLogger(VoteService.class);
    private static final LocalTime votingDeadline = LocalTime.of(11, 0);

    public Vote createOrUpdate(VoteTo voteTo, int userId) {
        ValidationUtil.checkNotFoundWithId(restaurantRepository.getById(voteTo.getRestaurantId()),
                voteTo.getRestaurantId());
        Assert.notNull(voteTo, "VoteTo must not be null.");
        Vote vote = createNewFromTo(voteTo, userId);
        Vote existing = voteRepository.getByUserIdAndDate(userId, LocalDate.now()).orElse(null);
        if (existing != null) {
            if (LocalTime.now().isBefore(votingDeadline)) {
                vote.setId(existing.getId());
                log.info("Change vote {} by user {} for today.", vote, userId);
                return voteRepository.save(vote);
            } else {
                log.info("It's too late to voting.");
                throw new DuplVoteException("It's too late to voting.");
            }
        }
        log.info("New vote {} by user {}.", vote, userId);
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

    public static Vote createNewFromTo(VoteTo voteTo, int userId) {
        return new Vote(null, LocalDate.now(), userId, voteTo.getRestaurantId());
    }

    public Vote createOrUpdateForTest(VoteTo voteTo, int userId, LocalTime requestTime) {
        ValidationUtil.checkNotFoundWithId(restaurantRepository.getById(voteTo.getRestaurantId()),
                voteTo.getRestaurantId());
        Assert.notNull(voteTo, "VoteTo must not be null.");
        Vote vote = createNewFromTo(voteTo, userId);
        vote.setDate(LocalDate.now());

        Vote existing = voteRepository.getByUserIdAndDate(userId, LocalDate.now()).orElse(null);
        if (existing != null) {
            if (requestTime.isBefore(votingDeadline)) {
                vote.setId(existing.getId());
                log.info("Change vote {} by user {} for today.", vote, userId);
                return voteRepository.save(vote);
            } else {
                log.info("It's too late to voting.");
                throw new DuplVoteException("It's too late to voting.");
            }
        }
        log.info("New vote {} by user {}.", vote, userId);
        return voteRepository.save(vote);
    }


}

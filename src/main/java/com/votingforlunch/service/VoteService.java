package com.votingforlunch.service;

import com.votingforlunch.model.Dish;
import com.votingforlunch.model.Vote;
import com.votingforlunch.repository.RestaurantRepository;
import com.votingforlunch.repository.VoteRepository;
import com.votingforlunch.to.VoteTo;
import com.votingforlunch.util.ValidationUtil;
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

    public Vote createOrUpdate(Vote vote, int userId) {

        ValidationUtil.checkNotFoundWithId(restaurantRepository.getReferenceById(vote.getRestaurantId()), vote.getRestaurantId());
        Assert.notNull(vote, "VoteTo must not be null.");


        Vote existing = voteRepository.getByUserIdAndDate(userId, LocalDate.now()).orElse(null);

        if (existing != null) {
            if (LocalTime.now().isBefore(votingDeadline)) {
                vote.setId(existing.getId());
                log.info("Change vote {} by user {} for today.", vote, userId);
                return voteRepository.save(vote);
            } else {
                log.info("It's too late to voting.");
                throw new RuntimeException("It's too late to voting.");
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



}

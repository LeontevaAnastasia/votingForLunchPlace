package com.votingforlunch.web;

import com.votingforlunch.model.Vote;
import com.votingforlunch.service.VoteService;
import com.votingforlunch.to.VoteTo;
import com.votingforlunch.util.SecurityUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;

@RestController
@RequestMapping(value = "/rest/restaurants/votes",  produces = MediaType.APPLICATION_JSON_VALUE)
public class VoteRestController {

   private final VoteService voteService;

    public VoteRestController(VoteService voteService) {
        this.voteService = voteService;
    }

    private final Logger log = LoggerFactory.getLogger(getClass());

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Vote> createToWithLocation(@RequestBody VoteTo voteTo) {
        log.info("Create new vote - {}.", voteTo);

        int userId = SecurityUtil.authUserId();
        Vote created = voteService.createOrUpdate(voteTo, userId);

        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/rest/restaurants/votes/{id}")
                .buildAndExpand(created.getId())
                .toUri();

        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody VoteTo voteTo) {
        log.info("Update vote {}.", voteTo);

        int userId = SecurityUtil.authUserId();
        voteService.createOrUpdate(voteTo, userId);
    }
}

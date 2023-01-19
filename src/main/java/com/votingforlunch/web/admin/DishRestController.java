package com.votingforlunch.web.admin;

import com.votingforlunch.model.Dish;
import com.votingforlunch.service.DishService;
import com.votingforlunch.util.ValidationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/rest/admin/restaurants/{restaurantId}/dishes", produces = MediaType.APPLICATION_JSON_VALUE)

public class DishRestController {

    private static final Logger log = LoggerFactory.getLogger(DishRestController.class);

    private final DishService dishService;

    public DishRestController(DishService dishService) {
        this.dishService = dishService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Dish> create(@Valid @RequestBody Dish dish, @PathVariable int restaurantId) {
        ValidationUtil.checkNew(dish);
        log.info("Create new dish {}", dish);
        Dish created = dishService.create(dish, restaurantId);

        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/rest/admin/restaurants/{restaurantId}/dishes/{id}")
                .buildAndExpand(restaurantId, created.getId()).toUri();

        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @GetMapping(value = "/{id}")
    public Dish get(@PathVariable int id, @PathVariable int restaurantId) {
        log.info("get dish {}", id);
        return dishService.getById(id,restaurantId);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id, @PathVariable int restaurantId) {
        log.info(("delete dish {}"), id);
        dishService.delete(id,restaurantId);
    }
    @GetMapping()
    public List<Dish> getAllForRestaurant(@PathVariable int restaurantId) {
        log.info("getAll dishes");
        return dishService.getAllForRestaurant(restaurantId);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@Valid @RequestBody Dish dish, @PathVariable int id, @PathVariable int restaurantId) {
        ValidationUtil.assureIdConsistent(dish, id);
        log.info("Update dish {}.", dish);
        dishService.update(dish, restaurantId);
    }

}

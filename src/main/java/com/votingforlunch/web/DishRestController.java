package com.votingforlunch.web;

import com.votingforlunch.model.Dish;
import com.votingforlunch.service.DishService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class DishRestController {

    private static final Logger log = LoggerFactory.getLogger(DishRestController.class);

    private final DishService dishService;

    public DishRestController(DishService dishService) {
        this.dishService = dishService;
    }

    public Dish get(int id, int restId) {
        log.info(("get dish {}"), id);
        return dishService.getById(id, restId);
    }

    public void delete(int id, int restId) {
        log.info(("delete dish {}"), id);
        dishService.delete(id,restId);
    }

    public List<Dish> getAll(int restId) {
        log.info("getAll dishes");
        return dishService.getAll(restId);
    }

}

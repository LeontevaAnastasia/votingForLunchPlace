package com.votingforlunch.web.dish;

import com.votingforlunch.model.Dish;
import com.votingforlunch.service.DishService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.List;

public class DishRestController {

    private static final Logger log = LoggerFactory.getLogger(DishRestController.class);

    private final DishService dishService;

    public DishRestController(DishService dishService) {
        this.dishService = dishService;
    }

    public Dish get(int id) {
        return dishService.getById(id);
    }

    public void delete(int id) {
        dishService.delete(id);
    }

    public List<Dish> getAll() {
        return dishService.getAll();
    }




}

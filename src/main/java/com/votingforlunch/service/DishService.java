package com.votingforlunch.service;

import com.votingforlunch.model.Dish;
import com.votingforlunch.repository.DishRepository;

import java.util.List;

import static com.votingforlunch.util.ValidationUtil.checkNotFoundWithId;

public class DishService {

    DishRepository dishRepository;

    public Dish create(Dish dish) {
        return dishRepository.save(dish);
    }

    public void delete(int id) {
        checkNotFoundWithId(dishRepository.delete(id), id);
    }

    public Dish getById(int id) {
        return checkNotFoundWithId(dishRepository.getReferenceById(id), id);
    }

    public List<Dish> getAll() {
        return dishRepository.findAll();
    }

    public void update(Dish dish) {
        checkNotFoundWithId(dishRepository.save(dish), dish.getId());
    }
}

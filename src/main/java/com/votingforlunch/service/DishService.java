package com.votingforlunch.service;

import com.votingforlunch.model.Dish;
import com.votingforlunch.model.Restaurant;
import com.votingforlunch.repository.DishRepository;
import com.votingforlunch.repository.RestaurantRepository;
import com.votingforlunch.util.ValidationUtil;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.votingforlunch.util.ValidationUtil.checkNotFoundWithId;

@Service
public class DishService {

    DishRepository dishRepository;
    RestaurantRepository restaurantRepository;

    public Dish create(Dish dish, int restId) {
        ValidationUtil.checkUniqueNameForRestaurant(dishRepository.getByNameForRestaurant(dish.getDishName(),restId)!=null);
        return dishRepository.save(dish);
    }

    public void delete(int id, int restId) {
        checkNotFoundWithId(dishRepository.delete(id,restId), id);
    }

    public Dish getById(int id, int restId) {
        return checkNotFoundWithId(dishRepository.findById(id,restId), id);
    }

    public List<Dish> getAll(int restId) {
        return dishRepository.getAllForRestaurant(restId);
    }

    public void update(Dish dish) {
        checkNotFoundWithId(dishRepository.save(dish), dish.getId());
    }

    public Dish save(Dish dish, int restId){
        if (!dish.isNew() && getById(dish.getId(), restId) == null) {
            return null;
        }
        dish.setRestaurant(restaurantRepository.getReferenceById(restId));
        return dishRepository.save(dish);
    }

}

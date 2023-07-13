package com.votingforlunch.service;

import com.votingforlunch.model.Dish;
import com.votingforlunch.repository.DishRepository;
import com.votingforlunch.repository.RestaurantRepository;
import com.votingforlunch.util.ValidationUtil;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

import static com.votingforlunch.util.ValidationUtil.checkNotFoundWithId;

@Service
@AllArgsConstructor
public class DishService {

    private final DishRepository dishRepository;

   private final RestaurantRepository restaurantRepository;

    public Dish create(Dish dish, int restId) {
        Assert.notNull(dish, "Dish must not be null.");
        ValidationUtil.checkUniqueNameForRestaurant(dishRepository.getByNameForRestaurant(dish.getDishName(),restId)!=null);
        return save(dish,restId);
    }

    public void delete(int id, int restId) {
        checkNotFoundWithId(dishRepository.delete(id,restId), id);
    }

    public Dish getById(int id, int restId) {
        return checkNotFoundWithId(dishRepository.findById(id,restId), id);
    }

    public List<Dish> getAllForRestaurant(int restId) {
        return ValidationUtil.checkNotFoundWithId(dishRepository.getAllForRestaurant(restId), restId);
    }

    public void update(Dish dish, int restId) {
        ValidationUtil.checkNotFoundWithId(save(dish, restId), dish.getId());
    }

    public Dish save(Dish dish, int restId){
        if (!dish.isNew() && getById(dish.getId(), restId) == null) {
            return null;
        }
        dish.setRestaurant(restaurantRepository.getById(restId));
        return dishRepository.save(dish);
    }

}

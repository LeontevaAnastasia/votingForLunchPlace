package com.votingforlunch.web.restaurant;

import com.votingforlunch.model.Restaurant;
import com.votingforlunch.model.User;
import com.votingforlunch.web.user.AbstractUserController;

import java.util.List;

public class RestaurantRestController extends AbstractRestaurantController {

    @Override
    public List<Restaurant> getAll() {
        return super.getAll();
    }

    @Override
    public Restaurant get(int id) {
        return super.get(id);
    }

    @Override
    public Restaurant create(Restaurant restaurant) {
        return super.create(restaurant);
    }

    @Override
    public void delete(int id) {
        super.delete(id);
    }

    @Override
    public void update(Restaurant restaurant) {
        super.update(restaurant);
    }
}


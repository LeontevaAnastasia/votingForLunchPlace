package com.votingforlunch;

import com.votingforlunch.model.Dish;

import java.time.LocalDate;


public class DishesTestData {

    public static final int DISH_ID1 = 1;
    public static final int DISH_ID2 = 2;
    public static final int DISH_ID = 3;
    public static final int DISH_NOT_FOUND = 10;

    public static final MatcherFactory.Matcher<Dish> DISH_MATCHER = MatcherFactory.usingIgnoringFieldsComparator(Dish.class);


    public static final Dish dish1 = new Dish(1,"Том-Ям", LocalDate.now(), 450.00, RestaurantTestData.shabby );
    public static final Dish dish2 = new Dish(2, "Стейк Рибай", LocalDate.now(), 870.00, RestaurantTestData.shabby);
    public static final Dish dish3 = new Dish(3, "Боул с угрем", LocalDate.now(), 540.00, RestaurantTestData.tokyoCity);
    public static final Dish dish4 = new Dish(4, "Хинкали", LocalDate.now(), 390.00, RestaurantTestData.phali);
    public static final Dish dish5 = new Dish(5, "Хачапури по аджарски", LocalDate.now(), 280.00, RestaurantTestData.phali);



    public static Dish getNewDish(){
        return new Dish(null,"NewDish",LocalDate.now(),123.00, null);
    }
    public static Dish getUpdatedDish() {
        Dish updated = new Dish(dish1);
        updated.setDishName("UpdatedName");
        updated.setPrice(500.00);
        updated.setRestaurant(RestaurantTestData.tokyoCity);
        return updated;
    }

    public static Dish getDuplicated() {
        return new Dish(null, dish1.getDishName(), LocalDate.now(),450.00, RestaurantTestData.shabby);
    }



}

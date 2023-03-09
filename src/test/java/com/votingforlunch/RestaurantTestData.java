package com.votingforlunch;

import com.votingforlunch.model.Restaurant;
import com.votingforlunch.to.RestaurantTo;

import java.util.ArrayList;
import java.util.List;




public class RestaurantTestData {


    public static final int REST_ID1 = 1;
    //public static final int REST_ID2 = 2;
    public static final int NOT_FOUND = 100;

    public static final MatcherFactory.Matcher<Restaurant> RESTAURANT_MATCHER = MatcherFactory.usingIgnoringFieldsComparator(Restaurant.class,"dishes");
    public static final MatcherFactory.Matcher<RestaurantTo> RESTAURANT_TO_MATCHER = MatcherFactory.usingIgnoringFieldsComparator(RestaurantTo.class,"dishes");

    public static final Restaurant shabby = new Restaurant(1, "Shabby", "Гороховая 11");
    public static final Restaurant tokyoCity = new Restaurant(2, "Tokyo City", "Невский пр. 71");
    public static final Restaurant phali = new Restaurant(3, "Пхали-Хинкали","Большая-Морская 27");

   public static List<Restaurant> restaurants = List.of(shabby,tokyoCity,phali);

    public static Restaurant getNewRest() {
        return new Restaurant(null, "NewRest", "Нахимова");
    }

    public static Restaurant getUpdatedRest() {
        Restaurant updated = new Restaurant(shabby);
        updated.setRestaurantName("UpdatedName");
        updated.setAddress("updated address");
        return updated;
    }
    public static List<RestaurantTo> getWithVotes(){

        List<RestaurantTo> restAndVotes = new ArrayList<>();
            restAndVotes.add(new RestaurantTo(shabby.getId(), 2L));
            restAndVotes.add(new RestaurantTo(tokyoCity.getId(), 1L));
            return restAndVotes;

    }

    public static Restaurant getNewDuplicate() {
        return new Restaurant(null, "Shabby", "Гороховая 11");
    }

}

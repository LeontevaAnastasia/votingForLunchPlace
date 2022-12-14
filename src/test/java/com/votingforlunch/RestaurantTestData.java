package com.votingforlunch;

import com.votingforlunch.model.Restaurant;
import java.util.List;




public class RestaurantTestData {


    public static final int REST_ID1 = 1;
    public static final int REST_ID2 = 2;
    public static final int NOT_FOUND_REST = 10;

    public static final MatcherFactory.Matcher<Restaurant> RESTAURANT_MATCHER = MatcherFactory.usingIgnoringFieldsComparator();

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

}

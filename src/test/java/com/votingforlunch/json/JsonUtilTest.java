package com.votingforlunch.json;

import com.votingforlunch.model.Dish;
import com.votingforlunch.web.json.JsonUtil;
import org.junit.jupiter.api.Test;
import java.util.List;

import static com.votingforlunch.DishesTestData.DISH_MATCHER;
import static com.votingforlunch.DishesTestData.dish1;

public class JsonUtilTest {

    @Test
    void readWriteValue() {
        String json = JsonUtil.writeValue(dish1);
        System.out.println(json);
        Dish dish = JsonUtil.readValue(json, Dish.class);
        DISH_MATCHER.assertMatch(dish, dish1);
    }

    @Test
    void readWriteValues() {
        String json = JsonUtil.writeValue(dish1);
        System.out.println(json);
        List<Dish> dishes = JsonUtil.readValues(json, Dish.class);
        DISH_MATCHER.assertMatch(dishes, dish1);
    }


}

package com.votingforlunch.repository;

import com.votingforlunch.model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface DishRepository extends JpaRepository<Dish, Integer> {

    @Modifying
    @Transactional
    @Query("delete from Dish d where d.id=:id and d.restaurant.id =:restId")
    int delete(@Param("id") int id, @Param("restId") int restId);

    @Query("select d from Dish d where d.dishName=:name and d.restaurant.id=:restId")
    Dish getByNameForRestaurant(@Param("name") String name, @Param("restId") int restId);

    @Query("select d from Dish d where d.id=:id and d.restaurant.id=:restId")
    Dish findById(@Param("id") int id, @Param("restId") int restId);

    @Query("select d from Dish d where d.restaurant.id=:restId order by d.dishName")
    List<Dish> getAllForRestaurant(@Param("restId") int restId);



}

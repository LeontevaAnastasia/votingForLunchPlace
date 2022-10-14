package com.votingforlunch.repository;

import com.votingforlunch.model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface DishRepository extends JpaRepository<Dish, Integer> {
    @Query("delete from Dish d where d.id=:id")
    boolean delete(@Param("id") int id);



}

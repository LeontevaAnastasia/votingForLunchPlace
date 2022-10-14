package com.votingforlunch.repository;

import com.votingforlunch.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {

    @Query("delete from Restaurant r where r.id=:id")
    boolean delete(@Param("id") int id);
}

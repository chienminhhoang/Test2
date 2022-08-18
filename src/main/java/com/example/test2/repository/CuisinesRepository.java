package com.example.test2.repository;

import com.example.test2.model.Cuisines;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CuisinesRepository extends JpaRepository<Cuisines, Long> {
    List<Cuisines> findAllByNameContaining(String name);
    @Query(value = "select * from cuisines where name like :name", nativeQuery = true)
    List<Cuisines> findByName(@Param("name") String name);
    @Query(value ="select max(price) from cuisines where price =(select max(price) from cuisines) ", nativeQuery = true )
    List<Cuisines> findMaxPrice(@Param("price") double price);
    @Query(value ="select min(price) from cuisines where price =(select min(price) from cuisines)", nativeQuery = true )
    List<Cuisines> findMinPrice(@Param("price") double price);
    @Query(value ="select min(AVG(price)) from cuisines where price =(select min(AVG(price)) from cuisines)", nativeQuery = true )
    List<Cuisines> findMinAVGPrice(@Param("price") double price);
}

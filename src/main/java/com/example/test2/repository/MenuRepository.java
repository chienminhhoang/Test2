package com.example.test2.repository;

import com.example.test2.model.Cuisines;
import com.example.test2.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MenuRepository  extends JpaRepository<Menu,Long> {
    @Query(value = "select * from menu where name like :name", nativeQuery = true)
    List<Menu> findByMenu(@Param("name") String name);

}

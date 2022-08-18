package com.example.test2.service;

import com.example.test2.Common.ICRUDService;
import com.example.test2.model.Cuisines;

import java.util.List;

public interface ICuisinesService extends ICRUDService<Cuisines> {
    List<Cuisines> findBySearch(String name);
    List<Cuisines> findBySearch1(double price);
    List<Cuisines> findBySearch2(double price);
    List<Cuisines> findBySearch3(double price);
    List<Cuisines> findBySearch4(double price);
}

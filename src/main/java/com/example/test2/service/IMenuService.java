package com.example.test2.service;

import com.example.test2.Common.ICRUDService;
import com.example.test2.model.Cuisines;
import com.example.test2.model.Menu;

import java.util.List;

public interface IMenuService extends ICRUDService<Menu> {
    List<Menu> findByMenu(String name);

}

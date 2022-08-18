package com.example.test2.service.impl;

import com.example.test2.model.Menu;
import com.example.test2.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class MenuService implements com.example.test2.service.IMenuService {
    @Autowired
    private MenuRepository menuRepository;
//    @Override
//    public Object save(Object o) {
//        return null;
//    }

    @Override
    public Menu save(Menu menu) {
        return menuRepository.save(menu);
    }

    @Override
    public void delete(Long id) {
        menuRepository.deleteById(id);

    }

    @Override
    public Optional findById(Long id) {
        return menuRepository.findById(id);
    }

    @Override
    public List findAll() {
        return menuRepository.findAll();
    }

    @Override
    public List<Menu> findByMenu(String name) {
        return  menuRepository.findByMenu("%"+name+"%");
    }
}

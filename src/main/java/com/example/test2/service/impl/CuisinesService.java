package com.example.test2.service.impl;

import com.example.test2.model.Cuisines;
import com.example.test2.repository.CuisinesRepository;
import com.example.test2.service.ICuisinesService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CuisinesService implements ICuisinesService {
    @Autowired
    public CuisinesRepository cuisinesRepository;
    @Override
    public Cuisines save(Cuisines student) {
        return cuisinesRepository.save(student);
    }
    @Override
    public void delete(Long id) {
        cuisinesRepository.deleteById(id);

    }

    @Override
    public Optional<Cuisines> findById(Long id) {
        return cuisinesRepository.findById(id);
    }

    @Override
    public List<Cuisines> findAll() {
        return cuisinesRepository.findAll();
    }

    @Override
    public List<Cuisines> findBySearch(String name) {
        return
                cuisinesRepository.findByName("%"+name+"%");
    }
    @Override
    public List<Cuisines> findBySearch1(double price) {
        return cuisinesRepository.findMaxPrice(Double.parseDouble("%"+price+"%"));
    }

    @Override
    public List<Cuisines> findBySearch2(double price) {
        return cuisinesRepository.findMinPrice(Double.parseDouble("%"+price+"%"));
    }

    @Override
    public List<Cuisines> findBySearch3(double price) {
        return cuisinesRepository.findMinAVGPrice(Double.parseDouble("%"+price+"%"));
    }

    @Override
    public List<Cuisines> findBySearch4(double price) {
        return null;
    }

//    @Override
//    public List<Cuisines> findBySearch(double price) {
//        return null;
//    }
//    @Override
//    public List<Cuisines> findBySearch(String name) {
////        return iStudentRepository.findAllByNameContaining(name);
//        return cuisinesRepository.findByName("%" + name + "%");
//    }
}

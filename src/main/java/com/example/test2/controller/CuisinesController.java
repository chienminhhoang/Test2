package com.example.test2.controller;

import com.example.test2.model.Cuisines;
import com.example.test2.model.Menu;
import com.example.test2.service.ICuisinesService;
import com.example.test2.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/cuisines1")
public class CuisinesController {
    @Autowired
    private ICuisinesService iCuisinesService;
    @Autowired
    private IMenuService menuService;

    @ModelAttribute("Cuisines")
    public List<Cuisines> cuisinesList() {
        return iCuisinesService.findAll();
    }

    @ModelAttribute("Menu")
    public List<Menu> menuList() {
        return menuService.findAll();
    }

    @GetMapping
    public ModelAndView findAllCuisines() {
        return new ModelAndView("display");

    }

    @GetMapping("/create")
    public ModelAndView CreateCuisines() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("cuisines", new Cuisines());
        return modelAndView;
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("cuisines") Optional<Cuisines> cuisines, RedirectAttributes redirectAttributes) {
        if (cuisines.isPresent()) {
            iCuisinesService.save(cuisines.get());
        } else {
            redirectAttributes.addFlashAttribute("message", "create fail, create again");
        }
        redirectAttributes.addFlashAttribute("message", "create successfully!!!!");
        return "redirect:/cuisines1";
    }

    @GetMapping("/update/{id}")
    public ModelAndView updateCuisines(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("update");
        Optional<Cuisines> cuisines = iCuisinesService.findById(id);
        if (cuisines.isPresent()) {
            iCuisinesService.save(cuisines.get());
            modelAndView.addObject("cuisines", cuisines.get());
        } else {
            modelAndView.addObject("message", "Cuisines Not Exist");
        }
        return modelAndView;
    }

    @PostMapping("/update/{id}")
    public String update(@ModelAttribute("cuisines") Optional<Cuisines> cuisines, RedirectAttributes redirectAttributes) {
        if (cuisines.isPresent()) {
            iCuisinesService.save(cuisines.get());
        } else {
            redirectAttributes.addFlashAttribute("message", "Update fail");
        }
        redirectAttributes.addFlashAttribute("message", "update successfully");
        return "redirect:/cuisines1";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        iCuisinesService.delete(id);
        redirectAttributes.addFlashAttribute("message", "delete successfully");
        return "redirect:/cuisines1";
    }

    @PostMapping("/search")
    public ModelAndView search(@RequestParam("search") Optional<String> name) {
        ModelAndView modelAndView = new ModelAndView("display");
//        List<Cuisines> cuisines;
        if (name.isPresent()) {
            List<Cuisines> cuisinesList = iCuisinesService.findBySearch(name.get());
            modelAndView.addObject("cuisines2", cuisinesList);
        }
        return modelAndView;
    }

    @PostMapping("/searchByMenu")
    public ModelAndView findByMenu(@ModelAttribute("Menu") Optional<String> name) {
        ModelAndView modelAndView = new ModelAndView("display");
//        List<Menu> menuList;
        if (name.isPresent()) {
            List<Menu> menuList = menuService.findByMenu(name.get());
            modelAndView.addObject("menu", menuList);
        }
        return modelAndView;
    }

    @PostMapping("/searchByMaxPrice")
    public ModelAndView findByMaxPrice(@ModelAttribute("price")Optional<Double>price){
        ModelAndView modelAndView= new ModelAndView("display");
        if (price.isPresent()){
            List<Cuisines> cuisines=iCuisinesService.findBySearch1(price.get());
            modelAndView.addObject("price",cuisines);
        }
        return modelAndView;
    }
    @PostMapping("/searchByMinPrice")
    public ModelAndView findByMinPrice(@ModelAttribute("price")Optional<Double>price){
        ModelAndView modelAndView= new ModelAndView("display");
        if (price.isPresent()){
            List<Cuisines> cuisines=iCuisinesService.findBySearch2(price.get());
            modelAndView.addObject("price",cuisines);
        }
        return modelAndView;
    }
    @PostMapping("/searchByMinAVGPrice")
    public ModelAndView findByMinAVGPrice(@ModelAttribute("price")Optional<Double>price){
        ModelAndView modelAndView= new ModelAndView("display");
        if (price.isPresent()){
            List<Cuisines> cuisines=iCuisinesService.findBySearch2(price.get());
            modelAndView.addObject("price",cuisines);
        }
        return modelAndView;
    }


}

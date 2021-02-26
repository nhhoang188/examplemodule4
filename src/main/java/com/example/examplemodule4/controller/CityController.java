package com.example.examplemodule4.controller;

import com.example.examplemodule4.model.City;
import com.example.examplemodule4.model.Country;
import com.example.examplemodule4.service.itf.CityService;
import com.example.examplemodule4.service.itf.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/")
public class CityController {
    @Autowired
    CityService cityService;
    @Autowired
    CountryService countryService;
    @ModelAttribute("countries")
    public Page<Country> listCountry(Pageable pageable){
        return countryService.findAll(pageable);
    }

    @GetMapping
    public ModelAndView test() {
        return new ModelAndView("/views/index");
    }
    @GetMapping("/city")
    public ModelAndView showListCity(@PageableDefault(size = 1) Pageable pageable, @RequestParam("search") Optional<String> s){
        Page<City> cities;
        if (s.isPresent()) {
            cities = cityService.findAllByName(pageable, s.get());
        } else {
            cities = cityService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/views/listall");
        modelAndView.addObject("cities", cities );
        return modelAndView ;
    }
    @GetMapping("/city/{id}")
    public ModelAndView showListCity(@PathVariable Long id){
        return new ModelAndView("/views/cityinfo", "city", cityService.findById(id));
    }
    @GetMapping("/city/add")
    public ModelAndView createForm(){
        ModelAndView modelAndView = new ModelAndView("views/add");
        modelAndView.addObject("city", new City());
        return modelAndView;
    }
    @PostMapping("/city/add")
    public ModelAndView createCity(@Validated @ModelAttribute("city") City city, BindingResult bindingResult){
        ModelAndView modelAndView = new ModelAndView("views/add");

        if (!bindingResult.hasFieldErrors()) {
            cityService.save(city);
            modelAndView.addObject("city", new City());
            modelAndView.addObject("message", "Success!");
        }
        return modelAndView;
    }

    @GetMapping("/city/edit/{id}")
    public ModelAndView editForm(@PathVariable("id") City city) {
        ModelAndView modelAndView = new ModelAndView("/views/edit");
        modelAndView.addObject("city", city);
        return modelAndView;
    }

    @PostMapping("/city/edit")
    public ModelAndView editCustomer(@ModelAttribute("customer") City city) {
        cityService.save(city);
        ModelAndView modelAndView = new ModelAndView("/views/edit");
        modelAndView.addObject("city", city);
        modelAndView.addObject("message", "update OK");
        return modelAndView;
    }
    @GetMapping("/city/delete/{id}")
    public ModelAndView deleteForm(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("/views/delete");
        modelAndView.addObject("id", id);
        return modelAndView;
    }

    @PostMapping("/city/delete")
    public ModelAndView modelAndView(@RequestParam("id") Long id){
        cityService.deleteById(id);
        ModelAndView modelAndView = new ModelAndView("/views/index");
        modelAndView.addObject("message", "Delete Success!");
        return modelAndView;
    }
}

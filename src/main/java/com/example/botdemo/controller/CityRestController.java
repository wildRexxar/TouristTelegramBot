package com.example.botdemo.controller;

import com.example.botdemo.entity.City;
import com.example.botdemo.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api")
@Controller
public class CityRestController {

    @Autowired
    private CityService cityService;

    @GetMapping("/cities")
    public List<City> showAllCities() {
        System.out.println(cityService.cityList());
        return null;
    }
}

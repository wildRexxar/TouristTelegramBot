package com.example.botdemo.controller;

import com.example.botdemo.entity.City;
import com.example.botdemo.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Component
public class CityRestController {

    @Autowired
    private CityService cityService;

    public String findCityFromDB(String title) {
        Optional <City> optional = cityService.cityList().stream()
                .filter(t -> t.getTitle().equals(title)).findFirst();
                if(optional.isPresent()) {
                    return optional.get().getTitle();
                } else {
                    return null;
                }
            }
        }
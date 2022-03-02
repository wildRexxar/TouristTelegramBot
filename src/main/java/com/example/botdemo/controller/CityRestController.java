package com.example.botdemo.controller;

import com.example.botdemo.entity.City;
import com.example.botdemo.exception_hadling.CityException;
import com.example.botdemo.service.CityServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CityRestController {

    private final CityServiceImpl cityService;

    public CityRestController(CityServiceImpl cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/cities/{city}")
    public City getCityFromBD(@PathVariable String city) {
        return cityService.getCity(city);
    }

    @GetMapping("/cities")
    public List<City> getAllCities() {
        return cityService.cityList();
    }

    @PostMapping("/cities")
    public City addNewCity(@RequestBody City city) {
        cityService.saveCity(city);
        return city;
    }

    @PutMapping("/cities")
    public City updateCity(@RequestBody City city) {
        cityService.saveCity(city);
        return city;
    }

    @DeleteMapping("/cities/{city}")
    public String deleteCity(@PathVariable String city) {
        City cityForDelete = cityService.getCity(city);
        if(cityForDelete == null) {
            throw  new CityException("City : " + city + " is not found");
        }
        cityService.deleteCity(city);

        return "City : " + city + " was deleted";
    }
}

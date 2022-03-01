package com.example.botdemo.service;

import com.example.botdemo.entity.City;

import java.util.List;

public interface CityService {
    List<City> cityList();

    void saveCity(City city);

    City getCity(int id);

    void deleteCity(int id);
}

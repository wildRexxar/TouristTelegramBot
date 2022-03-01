package com.example.botdemo.dao;

import com.example.botdemo.entity.City;

import java.util.List;

public interface CityDao {
    List<City> cityList();

    void saveCity(City city);

    City getCity(int id);

    void deleteCity(int id);
}

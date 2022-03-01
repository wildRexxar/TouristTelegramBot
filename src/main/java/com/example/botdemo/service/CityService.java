package com.example.botdemo.service;

import com.example.botdemo.dao.CityDao;
import com.example.botdemo.entity.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CityService {

    @Autowired
    private CityDao cityDao;


    @Transactional
    public List<City> cityList() {
        return cityDao.cityList();
    }

    @Transactional
    public void saveCity(City city) {
        cityDao.saveCity(city);
    }

    @Transactional
    public City getCity(int id) {
        return cityDao.getCity(id);
    }

    @Transactional
    public void deleteCity(int id) {
        cityDao.deleteCity(id);
    }
}

package com.example.botdemo.service;

import com.example.botdemo.dao.CityDao;
import com.example.botdemo.dao.CityDaoImpl;
import com.example.botdemo.entity.City;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    private final CityDao cityDao;

    public CityServiceImpl(CityDaoImpl cityDao) {
        this.cityDao = cityDao;
    }

    @Transactional
    public List<City> cityList() {
        return cityDao.cityList();
    }

    @Transactional
    public void saveCity(City city) {
        cityDao.saveCity(city);
    }

    @Transactional
    public City getCity(String title) {
        return cityDao.getCity(title);
    }

    @Transactional
    public void deleteCity(String city) {
        cityDao.deleteCity(city);
    }
}

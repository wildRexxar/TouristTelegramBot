package com.example.botdemo.dao;

import com.example.botdemo.entity.City;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CityDao {

    @Autowired
    private EntityManager entityManager;

    public List<City> cityList() {
        Session session = entityManager.unwrap(Session.class);
        return session
                .createQuery("from City ", City.class)
                .getResultList();
    }

    public void saveCity(City city) {

    }

    public City getCity(int id) {
        return null;
    }

    public void deleteCity(int id) {

    }
}

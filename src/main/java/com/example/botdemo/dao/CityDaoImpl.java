package com.example.botdemo.dao;

import com.example.botdemo.entity.City;
import com.example.botdemo.exception_hadling.CityException;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class CityDaoImpl implements CityDao {

    private final EntityManager entityManager;

    public CityDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<City> cityList() {
        Session session = entityManager.unwrap(Session.class);
        return session
                .createQuery("from City ", City.class)
                .getResultList();
    }

    public void saveCity(City city) {
        Session session = entityManager.unwrap(Session.class);
        List<City> cityCheck = cityList()
                .stream()
                .filter(t -> t.getTitle().equals(city.getTitle()))
                .collect(Collectors.toList());
        if (cityCheck.size() == 0 || cityCheck.size() == 1) {
            session.saveOrUpdate(city);
        } else {
            throw new CityException("This city already exists");
        }
    }

    public City getCity(String title) {
        Optional<City> optional = cityList().stream()
                .filter(t -> t.getTitle().equalsIgnoreCase(title)).findFirst();
        if (optional.isPresent()) {
            return optional.get();
        } else {
            return null;
        }
    }

    public void deleteCity(String city) {
        Session session = entityManager.unwrap(Session.class);
        session.createQuery("delete From City where title =:city")
                .setParameter("city", city)
                .executeUpdate();
    }
}


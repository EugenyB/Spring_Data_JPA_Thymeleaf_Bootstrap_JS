package com.example.demo.repo;

import com.example.demo.data.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Integer> {
    List<City> findByName(String name);
}
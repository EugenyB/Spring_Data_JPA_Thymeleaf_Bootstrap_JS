package com.example.demo.services;

import com.example.demo.data.City;
import com.example.demo.repo.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CityService {
    private final CityRepository cityRepository;

    public List<City> findAll() {
        return cityRepository.findAll();
    }
}

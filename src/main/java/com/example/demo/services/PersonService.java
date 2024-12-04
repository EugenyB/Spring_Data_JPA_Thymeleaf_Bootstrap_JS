package com.example.demo.services;

import com.example.demo.data.City;
import com.example.demo.data.Person;
import com.example.demo.repo.CityRepository;
import com.example.demo.repo.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;
    private final CityRepository cityRepository;

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public void addPerson(String name, int age, int cityId) {
//        List<City> cities = cityRepository.findByName(city);
        cityRepository.findById(cityId).ifPresent(city -> {
            Person person = new Person();
            person.setName(name);
            person.setAge(age);
            person.setCity(city);
            personRepository.save(person);
        });
    }

    public void updatePerson(int pid, String name, int age, int cityId) {
        personRepository.findById(pid).ifPresent(person -> {
           cityRepository.findById(cityId).ifPresent(city -> {
               person.setName(name);
               person.setAge(age);
               person.setCity(city);
               personRepository.save(person);
           });
        });
    }
}

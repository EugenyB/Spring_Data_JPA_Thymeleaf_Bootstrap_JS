package com.example.demo.controller;


import com.example.demo.services.CityService;
import com.example.demo.services.PersonService;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@AllArgsConstructor
@RequestMapping("/")
public class PersonController {

    private final PersonService personService;
    private final CityService cityService;

    @GetMapping("/people")
    public String getAll(Model model) {
        model.addAttribute("people", personService.findAll());
                model.addAttribute("cities", cityService.findAll());
        return "people";
    }

    @PostMapping("/add_person")
    public String addPerson(@RequestParam("person_name") String name, @RequestParam("person_age") int age, @RequestParam("person_city") int cityId) {
        personService.addPerson(name, age, cityId);
        return "redirect:/people";
    }

    @PostMapping("/update_person")
    public String updatePerson(
            @RequestParam("person_id") int pid,
            @RequestParam("person_name") String name,
            @RequestParam("person_age") int age,
            @RequestParam("person_city") int cityId) {
        personService.updatePerson(pid, name, age, cityId);
        return "redirect:/people";
    }
}


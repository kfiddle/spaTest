package com.example.demo.controllers;

import com.example.demo.models.Person;
import com.example.demo.repositories.PersonRepository;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;
import java.util.Collection;

@RestController
@CrossOrigin
public class PersonController {

    @Resource
    PersonRepository personRepo;

    @PostMapping("/add-person")
    public void addPerson(@RequestBody Person personToAdd) {
        personRepo.save(personToAdd);
    }

    @GetMapping("/all-persons")
    public Collection<Person> getTheFolks() {
        return (Collection<Person>) personRepo.findAll();
    }

}

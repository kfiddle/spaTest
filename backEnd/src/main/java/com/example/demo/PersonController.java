package com.example.demo;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collection;

@RestController
public class PersonController {

    @Resource
    PersonRepository personRepo;

    @PostMapping("/backend/add-person")
    public void addPerson(@RequestBody Person personToAdd) {
        personRepo.save(personToAdd);
    }

    @GetMapping("/backend/all-persons")
    public Collection<Person> getTheFolks() {
        return (Collection<Person>) personRepo.findAll();
    }

}

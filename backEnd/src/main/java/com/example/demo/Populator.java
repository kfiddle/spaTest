package com.example.demo;


import com.example.demo.models.Person;
import com.example.demo.repositories.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class Populator implements CommandLineRunner {

    @Resource
    PersonRepository personRepo;

    @Override
    public void run(String... args) throws Exception {

        Person joey = new Person("Joey", "Jablonski");
        Person chris = new Person("Chris", "VonV");
        Person wally = new Person("Wally");

        personRepo.save(joey);
        personRepo.save(chris);
        personRepo.save(wally);


    }
}

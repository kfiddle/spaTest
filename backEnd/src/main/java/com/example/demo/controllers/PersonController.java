package com.example.demo.controllers;

import com.example.demo.models.Person;
import com.example.demo.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;
import java.io.*;
import java.util.Collection;
import java.util.Properties;

@RestController
@CrossOrigin
public class PersonController {

    @Resource
    PersonRepository personRepo;

    @PostMapping("/add-person")
    public void addPerson(@RequestBody String firstNameToAdd) {
        Person personToAdd = new Person(firstNameToAdd);
        personRepo.save(personToAdd);
    }

    @GetMapping("/all-persons")
    public Collection<Person> getTheFolks() {
        return (Collection<Person>) personRepo.findAll();
    }

    @PostMapping ("/mail-send")
    public void sendEmail(@RequestBody String commentsToSend) throws IOException {


        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setUsername("kenjfiddle@gmail.com");
        mailSender.setPassword("Grandbanks1");


        File configFile = new File("application.properties");
        InputStream inputStream = new FileInputStream(configFile);
        Properties props = new Properties();

        props.load(inputStream);

        Properties properties = new Properties();
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.starttls.enable", "true");

        mailSender.setJavaMailProperties(properties);

        String from = "kenjfiddle@gmail.com";
        String to = "kenjfiddle@gmail.com";

        SimpleMailMessage message = new SimpleMailMessage();


        message.setFrom(from);
        message.setTo(to);
        message.setSubject(commentsToSend);
        message.setText("longestString");

        mailSender.send(message);


    }


}

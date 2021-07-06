package com.sparta.homework.controller;

import com.sparta.homework.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @GetMapping("/myinfo")
    public Person getPerson() {
        Person person = new Person();
        person.setName("김미진");
        person.setAge(24);
        person.setAddress("경기도");
        person.setJob("학생");
        return person;
    }
}

package com.example.TeamProject;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface PersonService {
    ArrayList<Person> findAll();
    Person addUser(Person person);
    Person findById(String id);
    boolean validateUser(String id, String pw);
}

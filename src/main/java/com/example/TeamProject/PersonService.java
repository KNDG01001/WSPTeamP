package com.example.TeamProject;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {
    private final List<Person> persons = new ArrayList<>();

    public void addUser(Person person) {
        persons.add(person);
    }

    public List<Person> getUsers() {
        return new ArrayList<>(persons);
    }
}

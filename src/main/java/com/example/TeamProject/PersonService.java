package com.example.TeamProject;

import java.util.ArrayList;

public class PersonService {
    private static final ArrayList<Person> persons = new ArrayList<>();

    public static void addUser(Person person) {
        persons.add(person);
    }

    public static ArrayList<Person> getUsers() {
        return persons;
    }
}

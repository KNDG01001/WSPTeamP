package com.example.TeamProject;

import java.util.ArrayList;

public class PersonServiceImpl implements PersonService {
    private ArrayList<Person> db = new ArrayList<>();

    public PersonServiceImpl(){
        System.out.println("LoginService Create");
        db.add(new Person("ydg","1234","양동건"));
        db.add(new Person("cys","1111","최용석"));
        db.add(new Person("lyj","2222","이용재"));
    }
    private ArrayList<Person> persons = new ArrayList<>();

    @Override
    public ArrayList<Person> findAll() {
        return persons;
    }

    @Override
    public Person addUser(Person person) {
        persons.add(person);
        return person;
    }

    @Override
    public Person findById(String id) {
        return null;
    }

    @Override
    public boolean validateUser(String id, String pw) {
        // validateUser 구현
        return persons.stream().anyMatch(person->person.getId().equals(id)&&person.getPw().equals(pw));
    }

}

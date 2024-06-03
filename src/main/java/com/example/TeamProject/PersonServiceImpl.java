package com.example.TeamProject;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PersonServiceImpl implements PersonService {
    private ArrayList<Person> db = new ArrayList<>();

    public PersonServiceImpl(){
        System.out.println("LoginService Create");
        db.add(new Person("ydg","1234","양동건"));
        db.add(new Person("cys","1111","최용석"));
        db.add(new Person("lyj","2222","이용재"));
    }

    @Override
    public ArrayList<Person> findAll() {
        return db;
    }

    @Override
    public Person addUser(Person person) {
        db.add(person);
        return person;
    }

    @Override
    public Person findById(String id) {
        return db.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean validateUser(String id, String pw) {
        // validateUser 구현
        Person user = findById(id);
        return user != null && user.getPw().equals(pw);
    }

}

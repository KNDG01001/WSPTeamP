package com.example.TeamProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository repository;

    @Override
    public List<PersonDTO> findAll() {
        return repository.findAll().stream()
                .map(PersonDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public void addUser(String id, String pw, String name) {
        Person person = Person.builder()
                .userId(id)
                .userPw(pw)
                .userName(name)
                .build();
        repository.save(person);
    }

    @Override
    public PersonDTO findById(String userId) {
        Optional<Person> person = repository.findById(userId);
        return person.map(PersonDTO::new).orElse(null);
    }

    @Override
    public boolean validateUser(String userId, String userPw) {
        PersonDTO userDto = findById(userId);
        if (userDto != null) {
            Person user = userDto.toEntity();
            return user.getUserPw().equals(userPw);
        }
        return false;
    }
}

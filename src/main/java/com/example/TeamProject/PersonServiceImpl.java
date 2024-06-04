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
    public void addUser(String userId, String userPw, String userName) {
        Person person = Person.builder()
                .userId(userId)
                .userPw(userPw)
                .userName(userName)
                .build();
        repository.save(person);
    }


    @Override
    public PersonDTO findById(String userId) {
        return repository.findById(userId).get().toDTO();
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

package com.example.TeamProject.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository repository;

    public void addUser(PersonDTO personDTO) {
        Person person = personDTO.toEntity();
        repository.save(person);
    }public boolean authorize(String userId, String userPw) {
        if (repository.findById(userId).isPresent()) {
            Person person = repository.findById(userId).get();
                return person.getUserPw().equals(userPw);
        }
        else{
            return false;
        }
    }
    public boolean duplicateCheck(PersonDTO personDTO) {
        return repository.findById(personDTO.getUserId()).isEmpty();
    }
    public PersonDTO findUserById(String userId) {
        return repository.findById(userId).get().toDTO();
    }


}

package com.example.TeamProject.User;

import com.sun.tools.jconsole.JConsoleContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public void addUser(PersonDTO personDTO) {
        Person person = personDTO.toEntity();
        repository.save(person);
    }

    @Override
    public boolean validateUser(String userId, String userPw) {
        System.out.println(repository.findById(userId));
        if (repository.findById(userId).isPresent()) {
            System.out.println("good");
            Person person = repository.findById(userId).get();
                return person.getUserPw().equals(userPw);
        }
        else{
        return false;
    }
    }
}

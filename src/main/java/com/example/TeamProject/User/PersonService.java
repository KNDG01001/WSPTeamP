package com.example.TeamProject.User;

import java.util.List;

public interface PersonService {
    List<PersonDTO> findAll();
    void addUser(PersonDTO person);
    PersonDTO findById(String userId);
    boolean validateUser(String userId, String userPw);
}

package com.example.TeamProject;

import java.util.List;

public interface PersonService {
    List<PersonDTO> findAll();
    void addUser(String userId, String userPw, String userName);
    PersonDTO findById(String userId);
    boolean validateUser(String userId, String userPw);
}

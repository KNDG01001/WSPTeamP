package com.example.TeamProject.User;

public interface PersonService {
    void addUser(PersonDTO personDTO);
    boolean authorize(String userId, String userPw);
    boolean duplicateCheck(PersonDTO personDTO);
    PersonDTO findUserById(String userId);
}

package com.example.TeamProject.User;

import java.util.List;

public interface PersonService {
    void addUser(PersonDTO personDTO);
    boolean authorize(String userId, String userPw);
    boolean duplicateCheck(PersonDTO personDTO);
}

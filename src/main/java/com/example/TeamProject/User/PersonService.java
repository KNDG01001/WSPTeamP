package com.example.TeamProject.User;

import java.util.List;

public interface PersonService {
    void addUser(PersonDTO person);
    boolean validateUser(String userId, String userPw);
}

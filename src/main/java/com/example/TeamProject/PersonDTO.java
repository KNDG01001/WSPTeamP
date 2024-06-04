package com.example.TeamProject;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PersonDTO {
    private String userId;
    private String userPw;
    private String userName;

    public PersonDTO(Person person) {
        userId = person.getUserId();
        userPw = person.getUserPw();
        userName = person.getUserName();
    }

    public Person toEntity() {
        return new Person(this);
    }
}

package com.example.TeamProject.User;

import jakarta.persistence.*;
import lombok.*;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
@Builder
public class Person {
    @Id
    private String userId;

    private String userPw;
    private String userName;
    public Person(PersonDTO person) {
        this.userId = person.getUserId();
        this.userPw = person.getUserPw();
        this.userName = person.getUserName();
    }

    public PersonDTO toDTO() {
        return new PersonDTO(this);
    }
}

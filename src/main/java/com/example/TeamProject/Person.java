package com.example.TeamProject;

import jakarta.persistence.*;
import lombok.*;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "person")
@Builder
@Setter
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private String userId; // String으로 변경

    private String userPw;

    private String userName;

    public Person(PersonDTO person) {
        userId = person.getUserId();
        userPw = person.getUserPw();
        userName = person.getUserName();
    }

    public PersonDTO toDTO() {
        return new PersonDTO(this);
    }
}

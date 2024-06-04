package com.example.TeamProject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, String> {
    @Query(value = "SELECT * FROM person", nativeQuery = true)
    List<Person> listM();
}

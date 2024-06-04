package com.example.TeamProject.Book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Query(value = "SELECT count(*) FROM book", nativeQuery = true)  long countbookS();
    List<Book> findByTitle (String title);
    List<Book>  findByTitleContaining(String title);

}

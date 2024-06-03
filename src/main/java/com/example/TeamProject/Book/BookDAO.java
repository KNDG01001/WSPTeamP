package com.example.TeamProject.Book;

import java.util.List;

public interface BookDAO {
    List<BookDTO> findAll();
    BookDTO findById(int id);

}
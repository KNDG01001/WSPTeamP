package com.example.TeamProject.Book;

import java.util.List;

public interface BookService {
    List<BookDTO> findAll();
    BookDTO findById(long bookId);
    void updateBook(BookDTO bookDTO);
}
package com.example.TeamProject.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements  BookService{
    @Autowired
    private BookRepository repository;
    @Override
    public List<BookDTO> findAll() {return repository.findAll().stream().map(BookDTO::new).collect(Collectors.toList());}
    @Override
    public BookDTO findById(long bookId) {return repository.findById(bookId).get().toDTO();}

}

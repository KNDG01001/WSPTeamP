package com.example.TeamProject.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookServiceImpl implements  BookService{
    @Autowired
    private BookDAO dao;

    @Override
    public List<BookDTO> findAll() {return dao.findAll();}

    @Override
    public BookDTO findById(int idx) {return dao.findById(idx);}

}

package com.example.TeamProject.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookController {

    @Autowired
    private BookService BookService;

    @RequestMapping("/BookList")
    public  String BookList(Model model) {
        model.addAttribute("books",BookService.findAll());
        return "BookList";
    }
    @RequestMapping("/list")  @ResponseBody
    public String list() {
    return "목록 : " + BookService.findAll();
}

    @RequestMapping("/BookDetail/{bookId}")
    public String BookDetail(@PathVariable("bookId") long bookId, Model model) {
            model.addAttribute("book", BookService.findById(bookId));
            return "BookDetail";
    }
}

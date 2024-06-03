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
    public String BookList(Model model) {
        model.addAttribute("books",BookService.findAll());
        return "BookList";
    }

    @RequestMapping("/BorrowList{id}")
    public String BorrowList(Model model){
        return "";
    }

    @RequestMapping("/BookDetail/{idx}")
    public String BookDetail(@PathVariable("idx") int idx, Model model) {
        try {
            BookDTO book = BookService.findById(idx);
            if (book == null) {
                model.addAttribute("error", "Book not found");
                return "error";
            }
            model.addAttribute("book", book);
            return "BookDetail";
        } catch (Exception e) {
            model.addAttribute("error", "An error occurred while retrieving the book details");
            return "error";
        }
    }
}

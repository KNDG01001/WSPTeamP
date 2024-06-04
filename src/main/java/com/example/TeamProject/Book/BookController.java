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

    @RequestMapping("/BorrowList")
    public String BorrowList(Model model){
        return "";
    }

    @RequestMapping("/BookDetail/{idx}")
    public String BookDetail(@PathVariable("idx") long idx, Model model) {
            model.addAttribute("book", BookService.findById(idx));
            return "BookDetail";
    }
}

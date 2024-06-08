package com.example.TeamProject.Book;

import com.example.TeamProject.Review.Review;
import com.example.TeamProject.Review.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService BookService;
    @Autowired
    private ReviewService reviewService;

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

    @RequestMapping("/BookDetail/{bookId}")
    public String BookDetail(@PathVariable("bookId") long bookId, Model model) {
            model.addAttribute("book", BookService.findById(bookId));
            List<Review> reviews = reviewService.findReviewsByBookId(bookId);
            model.addAttribute("reviews", reviews);
            return "BookDetail";
    }

}

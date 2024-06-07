package com.example.TeamProject.Review;

import com.example.TeamProject.Book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ReviewController {

    @Autowired
    private ReviewService reviewService;
    @Autowired
    private BookService bookService; // BookService를 주입받음

    @GetMapping("/review/{bookId}")
    public String getReviewsByBook(@PathVariable("bookId") long bookId, Model model) {
        model.addAttribute("reviews", reviewService.getReviewsByBook(bookId));
        return "BookDetail";
    }

    @PostMapping("/review")
    public String addReview(@RequestParam long bookId, @RequestParam String userId, @RequestParam String review) {
        reviewService.addReview(bookId, userId, review);
        return "redirect:/reviews/" + bookId;
    }
}

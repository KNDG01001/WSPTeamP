package com.example.TeamProject.Review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/BookReview/{bookId}")
    public String reviewWriting(@PathVariable String reviewId, Model model){
        model.addAttribute("review", ReviewService.findById(reviewId));
        return "BookReview";
    }

}

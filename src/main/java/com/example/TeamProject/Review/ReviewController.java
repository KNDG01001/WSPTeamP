package com.example.TeamProject.Review;

import com.example.TeamProject.Book.Book;
import com.example.TeamProject.Book.BookRepository;
import com.example.TeamProject.Book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ReviewController {

    @Autowired
    private ReviewService reviewService;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookService bookService;

    @GetMapping("/BookReview/{bookId}")
    public String ReviewWrite(@PathVariable long bookId, Model model) {
        model.addAttribute("bookId", bookId);
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        model.addAttribute("book", book);

        // 책에 대한 리뷰 목록 추가
        List<Review> reviews = reviewService.findReviewsByBookId(bookId);
        model.addAttribute("reviews", reviews);

        // ReviewDTO를 생성하여 모델에 추가
        ReviewDTO reviewDTO = reviewService.reviewWrite(bookId);
        model.addAttribute("reviewDTO", reviewDTO);
        return "BookReview";
    }

    @PostMapping("/reviewWrite")
    public String saveReview(@ModelAttribute ReviewDTO reviewDTO, long bookId, Model model) {
        reviewService.createReview(reviewDTO);

        // 리뷰가 저장된 후, BookDetail 페이지로 리다이렉트
        Book book = bookRepository.findById(reviewDTO.getBookId())
                .orElseThrow(() -> new RuntimeException("Book not found"));
        model.addAttribute("book", book);

        List<Review> reviews = reviewService.findReviewsByBookId(bookId);
        model.addAttribute("reviews", reviews);

        return "redirect:/BookDetail/" + reviewDTO.getBookId();

    }
    @PostMapping("/review")
    public String goToReviewWritePage(@RequestParam("bookId") long bookId, Model model) {
        model.addAttribute("bookId", bookId);
        return "redirect:/BookReview/" + bookId;
    }
}




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
    private BookService bookService;
    @Autowired
    private ReviewService reviewService;

    @RequestMapping("/BookList")
    public String BookList(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "BookList";
    }

    @RequestMapping("/BorrowList")
    public String BorrowList(Model model) {
        return "";
    }

    @RequestMapping("/BookDetail/{bookId}")
    public String BookDetail(@PathVariable("bookId") long bookId, Model model) {
        model.addAttribute("book", bookService.findById(bookId));
        List<Review> reviews = reviewService.findReviewsByBookId(bookId);
        model.addAttribute("reviews", reviews);
        return "BookDetail";
    }

    @PostMapping("/BookEdit")
    public String editBook(@RequestParam long bookId, @RequestParam String author,
                           @RequestParam String title, @RequestParam String image,
                           @RequestParam String detail) {
        BookDTO book = bookService.findById(bookId);
        book.setAuthor(author);
        book.setTitle(title);
        book.setImage(image);
        book.setDetail(detail);
        bookService.updateBook(book);
        return "redirect:/BookDetail/" + bookId;
    }

    @GetMapping("/BookEdit")
    public String bookEdit(@RequestParam long bookId, Model model) {
        model.addAttribute("book", bookService.findById(bookId));
        return "BookEdit";
    }
}

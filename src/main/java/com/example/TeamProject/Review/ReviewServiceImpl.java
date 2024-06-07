package com.example.TeamProject.Review;
import java.util.stream.Collectors;

import com.example.TeamProject.Book.Book;
import com.example.TeamProject.Book.BookDTO;
import com.example.TeamProject.Book.BookRepository;
import com.example.TeamProject.Borrow.BorrowRepository;
import com.example.TeamProject.User.Person;
import com.example.TeamProject.User.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private ReviewRepository reviewRepository; //리뷰

    @Autowired
    private BookRepository bookRepository; //책

    @Autowired
    private PersonRepository userRepository; //유저

    @Autowired
    private BorrowRepository borrowRepository; //대출

    @Override
    public ReviewDTO reviewWrite(long bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new RuntimeException("Book not found"));
        ReviewDTO reviewDTO = new ReviewDTO();
        reviewDTO.setBookId(bookId);
        return reviewDTO;
    }

    @Override
    public Review  createReview(ReviewDTO reviewDTO) {
        Book book = bookRepository.findById(reviewDTO.getBookId()).orElseThrow(() -> new RuntimeException("Book not found"));
        Person user = userRepository.findById(reviewDTO.getUserId()).orElseThrow(() -> new RuntimeException("User not found"));
        Review review = new Review(reviewDTO, book, user);
        return reviewRepository.save(review);
    }

    @Override
    public List<Review> findReviewsByBookId(long bookId) {
        return reviewRepository.findByBook_BookId(bookId);
    }




}

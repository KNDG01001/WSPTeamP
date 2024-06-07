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
    private ReviewRepository reviewRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private PersonRepository userRepository;

    @Override
    public List<ReviewDTO> getReviewsByBook(long bookId) {
        List<Review> reviews = reviewRepository.findByBookBookId(bookId);
        return reviews.stream().map(ReviewDTO::new).collect(Collectors.toList());
    }

    @Override
    public void addReview(long bookId, String userId, String review) {
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new RuntimeException("Book not found"));
        Person user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        ReviewDTO reviewDTO = new ReviewDTO();
        reviewDTO.setBookId(bookId);
        reviewDTO.setUserId(userId);
        reviewDTO.setReview(review);
        Review reviewEntity = reviewDTO.toEntity(user, book);
        reviewRepository.save(reviewEntity);
    }
}

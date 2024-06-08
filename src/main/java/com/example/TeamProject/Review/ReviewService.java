package com.example.TeamProject.Review;

import com.example.TeamProject.Book.Book;
import com.example.TeamProject.Book.BookDTO;
import com.example.TeamProject.Book.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ReviewService {
    ReviewDTO reviewWrite(long bookId);
    Review createReview(ReviewDTO reviewDTO);
    List<Review> findReviewsByBookId(long bookId);

}

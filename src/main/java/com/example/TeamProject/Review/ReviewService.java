package com.example.TeamProject.Review;

import java.util.List;

public interface ReviewService {
    ReviewDTO reviewWrite(long bookId);
    Review createReview(ReviewDTO reviewDTO);
    List<Review> findReviewsByBookId(long bookId);

}

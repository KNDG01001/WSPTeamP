package com.example.TeamProject.Review;

import com.example.TeamProject.Book.Book;
import com.example.TeamProject.User.Person;
import lombok.*;

@Getter @Setter
@ToString @NoArgsConstructor
@AllArgsConstructor
public class ReviewDTO {
    private long reviewId;
    private long bookId;
    private String userId;
    private String review;

    public ReviewDTO(Review review1){
        reviewId = review1.getReviewId();
        bookId = review1.getBook().getBookId();
        userId = review1.getUser().getUserId();
        review = review1.getReview();
    }
    public Review toEntity(Person user, Book book){
        return new Review(this,book, user);
    }




}

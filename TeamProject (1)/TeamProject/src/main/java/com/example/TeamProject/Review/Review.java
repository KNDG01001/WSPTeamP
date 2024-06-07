package com.example.TeamProject.Review;

import jakarta.persistence.*;
import lombok.*;

@Getter @ToString
@NoArgsConstructor @AllArgsConstructor
@Entity @Table(name="review")
@Builder
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long reviewId;
    private String reviewContent;
    private long rate;

    public Review(ReviewDTO review){
        reviewId = review.getReviewId();
        reviewContent = review.getReviewContent();
        rate = review.getRate();
    }

    public ReviewDTO toDTO(){return new ReviewDTO(this);}
}

package com.example.TeamProject.Review;

import lombok.*;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @ToString
public class ReviewDTO {
    private long reviewId;
    private String reviewContent;
    private long rate;

    public ReviewDTO(Review review){
        reviewId = review.getReviewId();
        reviewContent = review.getReviewContent();
        rate = review.getRate();
    }
    public Review toEntity(){return new Review(this);}
}

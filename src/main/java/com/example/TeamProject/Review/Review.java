package com.example.TeamProject.Review;

import com.example.TeamProject.Book.Book;
import com.example.TeamProject.User.Person;
import jakarta.persistence.*;
import lombok.*;

@Getter @ToString
@NoArgsConstructor @AllArgsConstructor
@Entity @Table(name="reviews")
@Builder
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //자동생성
    private long reviewId;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Person user;

    private String review;

    public Review(ReviewDTO reviewDTO, Book book, Person user){
        reviewId=reviewDTO.getReviewId();
        this.book = book;
        this.user = user;
        this.review = reviewDTO.getReview();
    }

    public ReviewDTO toDTO(){
        return new ReviewDTO(this);
    }

}

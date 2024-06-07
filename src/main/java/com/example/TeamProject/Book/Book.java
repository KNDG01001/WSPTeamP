package com.example.TeamProject.Book;

import com.example.TeamProject.Review.Review;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter @ToString
@NoArgsConstructor @AllArgsConstructor
@Entity @Table(name="books")
@Builder
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //자동생성
    private long bookId;

    private String title;
    private String author;
    private String image;
    private String detail;

    private String lyj;
    private String review;


    public Book(BookDTO book) {
        bookId = book.getBookId();
        title = book.getTitle();
        author = book.getAuthor();
        image = book.getImage();
        detail = book.getDetail();
        review = book.getReview();
    }

    public BookDTO toDTO() {
        return new BookDTO(this);
    }
}
package com.example.TeamProject.Book;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter @ToString
@NoArgsConstructor @AllArgsConstructor
@Entity @Table(name="books")
@Builder
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idx;
    private String title;
    private String author;
    private String image;
    private String detail;
    private int rate;
//    private String review;


    public Book(Book book) {
        idx = book.getIdx();
        title = book.getTitle();
        author = book.getAuthor();
        image = book.getImage();
        detail = book.getDetail();
        rate = book.getRate();
//        review = book.getReview();
    }

    public BookDTO toDTO() {
        return new BookDTO(this);
    }

}
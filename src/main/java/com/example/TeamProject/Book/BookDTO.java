package com.example.TeamProject.Book;

import lombok.*;
import java.util.List;

@Getter @Setter  @ToString
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {
    private long idx;
    private String title;
    private String author;
    private String image;
    private String detail;
    private int rate;
//    private String review;

    public BookDTO(Book book) {
        idx = book.getIdx();
        title = book.getTitle();
        author = book.getAuthor();
        image = book.getImage();
        detail = book.getDetail();
        rate = book.getRate();
//        review = book.getReview();
    }

    public Book toEntity() {
        return new Book(this.toEntity());
    }
}
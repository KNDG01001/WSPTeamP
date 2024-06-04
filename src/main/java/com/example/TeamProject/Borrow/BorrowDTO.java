package com.example.TeamProject.Borrow;

import com.example.TeamProject.Book.Book;
import lombok.*;

import java.util.Date;

@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor
public class BorrowDTO {
    private long borrowId;
    private String userId;
    private long bookId;
    private Date borrowDate;
    private Date returnDate;

    public BorrowDTO(Borrow borrow) {
        borrowId = borrow.getBorrowId();
        userId = borrow.getUser().getUserId();
        bookId = borrow.getBook().getBookId();
        borrowDate = borrow.getBorrowDate();
        returnDate = borrow.getReturnDate();
    }

    public Borrow toEntity(User user, Book book) {
        return new Borrow(this, user, book);
    }
}

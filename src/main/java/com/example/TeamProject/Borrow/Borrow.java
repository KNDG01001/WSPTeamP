package com.example.TeamProject.Borrow;

import com.example.TeamProject.Book.Book;
import com.example.TeamProject.User.Person; //user가 들어와야함
import jakarta.persistence.*;
import lombok.*;


import java.util.Date;

@Getter @ToString
@NoArgsConstructor @AllArgsConstructor
@Entity @Table(name = "borrows")
@Builder
public class Borrow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //자동생성
    private long borrowId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Person user;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    private Date borrowDate;
    private Date returnDate;

    public Borrow(BorrowDTO borrowDTO, Person user, Book book) {
        borrowId = borrowDTO.getBorrowId();
        this.user = user;
        this.book = book;
        borrowDate = borrowDTO.getBorrowDate();
        returnDate = borrowDTO.getReturnDate();
    }

    public BorrowDTO toDTO() {
        return new BorrowDTO(this);
    }
}

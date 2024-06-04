package com.example.TeamProject.Borrow;

import java.util.List;
public interface BorrowService {
    public List<Borrow> getBorrowsByUser(String userId); // 사용자에게 대출 현황 보여주기 위한
    public void borrowBook(String userId, long bookId); // 대출
    public void returnBook(String userId, long bookId); // 반납
}

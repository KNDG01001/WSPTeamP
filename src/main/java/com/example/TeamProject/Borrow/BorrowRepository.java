package com.example.TeamProject.Borrow;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BorrowRepository extends JpaRepository<Borrow, String> {
    List<Borrow> findByUserUserId(String userId);
    Borrow findByUserUserIdAndBookBookId(String userId, long bookId);
    void delete(Borrow borrow);
}
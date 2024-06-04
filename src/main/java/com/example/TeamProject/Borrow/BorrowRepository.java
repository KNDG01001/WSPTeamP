package com.example.TeamProject.Borrow;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface BorrowRepository extends JpaRepository<Borrow, String> {
    List<Borrow> findByUserId(String userId);
    List<Borrow> findByUserIdBookId(String userId, long bookId);
    void delete(List<Borrow> borrow);
}
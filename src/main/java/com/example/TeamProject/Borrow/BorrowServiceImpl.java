package com.example.TeamProject.Borrow;

import com.example.TeamProject.Book.Book;
import com.example.TeamProject.Book.BookRepository;
import com.example.TeamProject.User.Person;
import com.example.TeamProject.User.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class BorrowServiceImpl implements BorrowService {
    //시간 계산
    LocalDate now = LocalDate.now();
    LocalDate oneWeekLater = now.plusWeeks(1);
    Date returnDate = java.sql.Date.valueOf(oneWeekLater);

    @Autowired
    private BorrowRepository borrowRepository; // 대출
    @Autowired
    private BookRepository bookRepository; // 책
    @Autowired
    private PersonRepository userRepository; // 유저

    @Override // 해당 ID의 유저 대출 현황 리턴
    public List<Borrow> getBorrowsByUser(String userId) {
        return borrowRepository.findByUserUserId(userId);
    }
    @Override // 대출 구현
    public void borrowBook(String userId, long bookId) {
        Person user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Can't find user"));
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new RuntimeException("Can't find book"));
        Borrow access = borrowRepository.findByUserUserIdAndBookBookId(userId, bookId); // 해당 유저ID가 빌린 책 ID로 찾아서 이미 이 책을 빌렸으면 다시 못빌리게
        if(access!=null){ //이미 있으면
            System.out.println("Already Borrowed");
        }else{ //borrowdto에 넘겨진 값 저장
            BorrowDTO borrowDTO = new BorrowDTO();
            borrowDTO.setUserId(userId);
            borrowDTO.setBookId(bookId);
            borrowDTO.setBorrowDate(new Date()); //대출은 오늘 날짜로
            borrowDTO.setReturnDate(returnDate); //일주일 뒤 반납
            access = borrowDTO.toEntity(user, book); // Entitiy로 변환해서
            borrowRepository.save(access); // db에 저장
        }
    }
    @Override // 반납 구현
    public void returnBook(String userId, long bookId) {
            Borrow borrow = borrowRepository.findByUserUserIdAndBookBookId(userId, bookId); // 해당 유저ID가 빌린 책 ID로 찾아서
            borrowRepository.delete(borrow); //삭제
        }
    }

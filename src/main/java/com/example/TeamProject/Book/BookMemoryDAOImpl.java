package com.example.TeamProject.Book;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookMemoryDAOImpl implements BookDAO {
    private List<BookDTO> db = new ArrayList<>();
    List<String> Review = new ArrayList<>();
    public BookMemoryDAOImpl(){
        Review.add("test");
        Review.add("test2");
        Review.add("test3");

        System.out.println("BookService Create");
        db.add(new BookDTO(1, "이상한 책들의 도서관","에드워드 브룩","/images/library of strange books.jpg","희귀 서적 수집가가 안내하는 역사상 가장 기이하고 저속하며 발칙한 책들의 세계",0,new ArrayList<>(Review)));
        db.add(new BookDTO(2, "계급 천장","샘프리드먼, 대니얼로리슨","/images/class ceiling.jpg","커리어와 인생에 드리운 긴 그림자",0,new ArrayList<>(Review)));
        db.add(new BookDTO(3, "아주 작은 대화의 기술","레일 라운즈","/images/A very small conversation.jpg","힘들이지 않고 사람의 마음을 얻는 80가지 인간관계의 기술",0,new ArrayList<>(Review)));
        db.add(new BookDTO(4, "모순","양귀자","/images/contradiction.jpg","양장본 Hardcover",0,new ArrayList<>(Review)));
        db.add(new BookDTO(5, "사랑 사건 오류 ", "김나현","/images/incident love error.jpg","김나현 장편소설",0,new ArrayList<>(Review)));
        db.add(new BookDTO(6,"먼 곳에서","에르난 디아스", "/images/from afar.jpg","에르난 디아스 장편소설",0,new ArrayList<>(Review)));
    }

    @Override
    public List<BookDTO> findAll() {
        return db;
    }
    @Override
    public BookDTO findById(int idx) {
        return db.stream().filter(b -> b.getIdx() == idx).findFirst().get();
    }
}

    package com.example.TeamProject.Book;

    import com.example.TeamProject.Review.Review;
    import lombok.*;

    import java.util.List;

    @Getter @Setter  @ToString
    @NoArgsConstructor @AllArgsConstructor
    public class BookDTO {
        private long bookId;
        private String title;
        private String author;
        private String image;
        private String detail;
        private String review;

        public BookDTO(Book book) {
            bookId = book.getBookId();
            title = book.getTitle();
            author = book.getAuthor();
            image = book.getImage();
            detail = book.getDetail();
            review = book.getReview();
        }

        public Book toEntity() {
            return new Book(this);
        }
    }
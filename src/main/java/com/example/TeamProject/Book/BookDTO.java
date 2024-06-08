    package com.example.TeamProject.Book;

    import lombok.*;

    @Getter @Setter  @ToString
    @NoArgsConstructor @AllArgsConstructor
    public class BookDTO {
        private long bookId;
        private String title;
        private String author;
        private String image;
        private String detail;


        public BookDTO(Book book) {
            bookId = book.getBookId();
            title = book.getTitle();
            author = book.getAuthor();
            image = book.getImage();
            detail = book.getDetail();
        }

        public Book toEntity() {
            return new Book(this);
        }
    }
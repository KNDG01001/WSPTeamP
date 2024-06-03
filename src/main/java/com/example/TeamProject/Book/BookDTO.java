package com.example.TeamProject.Book;

import lombok.*;
import java.util.List;

@Getter @Setter  @ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookDTO {
    private int idx;
    private String title;
    private String author;
    private String image;
    private String detail;
    private int rate;
    private List<String> review;
}
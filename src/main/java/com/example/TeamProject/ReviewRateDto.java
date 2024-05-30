package com.example.TeamProject;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewRateDto {
    private int rate;
    private String review;
}

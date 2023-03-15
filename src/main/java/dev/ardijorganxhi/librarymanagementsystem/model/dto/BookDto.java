package dev.ardijorganxhi.librarymanagementsystem.model.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {

    private long id;
    private String name;
    private int stock;
}

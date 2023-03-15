package dev.ardijorganxhi.librarymanagementsystem.model.dto;

import lombok.*;
import net.bytebuddy.asm.Advice;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookBorrowDto {

    private String user;
    private String book;
    private LocalDate borrowDate;
    private LocalDate returnDate;

}

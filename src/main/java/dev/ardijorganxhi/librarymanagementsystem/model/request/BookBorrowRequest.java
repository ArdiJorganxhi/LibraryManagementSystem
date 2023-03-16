package dev.ardijorganxhi.librarymanagementsystem.model.request;

import lombok.*;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookBorrowRequest {
    @NotBlank(message = "A borrow date should be provided!")
    private LocalDate borrowDate;
    @NotBlank(message = "A return date should be provided!")
    private LocalDate returnDate;
}

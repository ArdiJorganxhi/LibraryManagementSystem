package dev.ardijorganxhi.librarymanagementsystem.model.response;

import dev.ardijorganxhi.librarymanagementsystem.model.dto.BookBorrowDto;
import dev.ardijorganxhi.librarymanagementsystem.model.dto.BookDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookBorrowResponse {

    private List<BookBorrowDto> content;
    private int pageNo;
    private int pageSize;
    private int totalPages;
    private long totalElements;
    private boolean last;
}

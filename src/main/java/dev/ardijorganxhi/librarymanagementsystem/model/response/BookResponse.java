package dev.ardijorganxhi.librarymanagementsystem.model.response;

import dev.ardijorganxhi.librarymanagementsystem.model.dto.BookDto;
import dev.ardijorganxhi.librarymanagementsystem.model.dto.UserDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookResponse {

    private List<BookDto> content;
    private int pageNo;
    private int pageSize;
    private int totalPages;
    private long totalElements;
    private boolean last;
}

package dev.ardijorganxhi.librarymanagementsystem.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import dev.ardijorganxhi.librarymanagementsystem.embedded.BookId;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@IdClass(BookId.class)
public class BookBorrow {

    @Id
    private long bookId;
    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate borrowDate;
    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate returnDate;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}

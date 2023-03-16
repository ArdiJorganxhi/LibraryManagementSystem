package dev.ardijorganxhi.librarymanagementsystem.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.ardijorganxhi.librarymanagementsystem.model.embedded.BookUserId;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class BookBorrow {


    @EmbeddedId
    private BookUserId id = new BookUserId();

    @ManyToOne
    @MapsId("bookId")
    @JoinColumn(name = "book_id")
    @JsonIgnore
    private Book book;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;
    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    @NotBlank(message = "A borrow date should be provided!")
    private LocalDate borrowDate;
    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    @NotBlank(message = "A return date should be provided!")
    private LocalDate returnDate;



}

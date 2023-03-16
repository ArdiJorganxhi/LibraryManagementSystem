package dev.ardijorganxhi.librarymanagementsystem.entity;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    @NotBlank(message = "A name must be given for book!")
    private String name;
    @Column(nullable = false)
    @NotBlank(message = "Author should be provided for book!")
    private String author;
    @Column(nullable = false)
    @NotBlank(message = "Number of pages should be given!")
    private int page;

    @Column(nullable = false)
    @NotBlank(message = "Please enter stock number of book!")
    private int stock;

    @OneToMany(mappedBy = "book")
    private List<BookBorrow> bookBorrows = new ArrayList<>();
}

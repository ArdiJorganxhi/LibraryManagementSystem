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
    private String name;
    @Column(nullable = false)
    private String author;
    @Column(nullable = false)
    private int page;

    @Column(nullable = false)
    private int stock;

    @OneToMany(mappedBy = "book")
    private List<BookBorrow> bookBorrows = new ArrayList<>();
}

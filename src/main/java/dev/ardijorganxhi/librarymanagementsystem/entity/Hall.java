package dev.ardijorganxhi.librarymanagementsystem.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Hall {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    @NotBlank(message = "A name must be given!")
    private String name;
    private int emptySeats = 0;
    @Column(nullable = false)
    @NotBlank(message = "Total seats should be provided!")
    private int totalSeats;
}

package dev.ardijorganxhi.librarymanagementsystem.model.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HallDto {

    private long id;
    private String name;
    private int emptySeats;
    private int totalSeats;
}

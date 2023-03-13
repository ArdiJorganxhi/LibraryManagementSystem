package dev.ardijorganxhi.librarymanagementsystem.model.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateHallRequest {

    private String name;
    private int totalSeats;
}

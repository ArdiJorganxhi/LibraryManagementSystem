package dev.ardijorganxhi.librarymanagementsystem.model.request;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateHallRequest {

    @NotBlank(message = "A name must be given!")
    private String name;
    @NotBlank(message = "Total seats should be provided!")
    private int totalSeats;
}

package dev.ardijorganxhi.librarymanagementsystem.model.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserDto {

    private long id;
    private String name;
    private String surname;

}

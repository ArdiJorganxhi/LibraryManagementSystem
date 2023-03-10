package dev.ardijorganxhi.librarymanagementsystem.model.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RegisterBookRequest {

    private String name;
    private String author;
    private int page;
}

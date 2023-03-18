package dev.ardijorganxhi.librarymanagementsystem.model.request;

import lombok.*;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RegisterBookRequest {

    @NotBlank(message = "A name must be given for book!")
    private String name;
    @NotBlank(message = "Author should be provided for book!")
    private String author;
    @NotBlank(message = "Number of pages should be provided!")
    private int page;
    private int stock;
}

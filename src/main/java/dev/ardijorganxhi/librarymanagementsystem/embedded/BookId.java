package dev.ardijorganxhi.librarymanagementsystem.embedded;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
@Getter
@Setter
public class BookId implements Serializable {

    private long bookId;
    private long userId;
}

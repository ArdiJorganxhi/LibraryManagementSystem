package dev.ardijorganxhi.librarymanagementsystem.entity;

import dev.ardijorganxhi.librarymanagementsystem.model.enums.TokenType;
import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Token {

    @Id
    @GeneratedValue
    private long id;

    @Column(unique = true)
    private String token;

    @Enumerated(EnumType.STRING)
    public TokenType tokenType = TokenType.BEARER;

    public boolean revoked;
    public boolean expired;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}

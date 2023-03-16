package dev.ardijorganxhi.librarymanagementsystem.entity;

import dev.ardijorganxhi.librarymanagementsystem.model.enums.Role;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    @NotBlank(message = "Name should be filled!")
    private String name;
    @Column(nullable = false)
    @NotBlank(message = "Surname should be filled!")
    private String surname;
    @Column(nullable = false, unique = true)
    @NotBlank(message = "Email should be filled!")
    @Email(message = "It must be a valid email format!")
    private String email;
    @Column(nullable = false)
    @NotBlank(message = "Password should be filled!")
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;


    @OneToMany(mappedBy = "user")
    private List<BookBorrow> books = new ArrayList<>();

    @OneToOne(mappedBy = "user")
    private Subscription subscription;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

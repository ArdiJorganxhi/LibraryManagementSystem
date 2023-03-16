package dev.ardijorganxhi.librarymanagementsystem.mapper;

import dev.ardijorganxhi.librarymanagementsystem.model.response.UserResponse;
import dev.ardijorganxhi.librarymanagementsystem.utils.ValidationUtils;
import dev.ardijorganxhi.librarymanagementsystem.entity.User;
import dev.ardijorganxhi.librarymanagementsystem.model.dto.UserDto;
import dev.ardijorganxhi.librarymanagementsystem.model.enums.Role;
import dev.ardijorganxhi.librarymanagementsystem.model.request.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserMapper {

    private final PasswordEncoder passwordEncoder;
    private final ValidationUtils validationUtils;

    public UserDto toDto(User user){

        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .surname(user.getSurname())
                .build();
    }

    public User register(RegisterRequest request) throws Exception{
        return User.builder()
                .name(request.getName())
                .surname(request.getSurname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
    }
    public List<UserDto> listToDto(List<User> users){
        return users.stream().map(this::toDto).collect(Collectors.toList());
    }

    public UserResponse toResponse(Page<User> userPage){

        return UserResponse.builder()
                .content(listToDto(userPage.getContent()))
                .pageNo(userPage.getNumber())
                .pageSize(userPage.getSize())
                .totalPages(userPage.getTotalPages())
                .totalElements(userPage.getTotalElements())
                .last(userPage.isLast())
                .build();

    }

}

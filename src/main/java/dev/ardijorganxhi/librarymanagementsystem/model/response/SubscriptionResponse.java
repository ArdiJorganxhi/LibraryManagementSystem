package dev.ardijorganxhi.librarymanagementsystem.model.response;

import dev.ardijorganxhi.librarymanagementsystem.model.dto.SubscriptionDto;
import dev.ardijorganxhi.librarymanagementsystem.model.dto.UserDto;
import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionResponse {

    private List<SubscriptionDto> content;
    private int pageNo;
    private int pageSize;
    private int totalPages;
    private long totalElements;
    private boolean last;
}

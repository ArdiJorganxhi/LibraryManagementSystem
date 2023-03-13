package dev.ardijorganxhi.librarymanagementsystem.mapper;

import dev.ardijorganxhi.librarymanagementsystem.entity.Hall;
import dev.ardijorganxhi.librarymanagementsystem.model.request.CreateHallRequest;
import org.springframework.stereotype.Component;

@Component
public class HallMapper {

    public Hall createHall(CreateHallRequest request){
        return Hall.builder()
                .name(request.getName())
                .totalSeats(request.getTotalSeats())
                .build();
    }
}

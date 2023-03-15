package dev.ardijorganxhi.librarymanagementsystem.mapper;

import dev.ardijorganxhi.librarymanagementsystem.entity.Hall;
import dev.ardijorganxhi.librarymanagementsystem.model.dto.HallDto;
import dev.ardijorganxhi.librarymanagementsystem.model.request.CreateHallRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class HallMapper {

    public Hall createHall(CreateHallRequest request){
        return Hall.builder()
                .name(request.getName())
                .totalSeats(request.getTotalSeats())
                .build();
    }

    public HallDto toDto(Hall hall){
        return HallDto.builder()
                .id(hall.getId())
                .name(hall.getName())
                .emptySeats(hall.getEmptySeats())
                .totalSeats(hall.getTotalSeats())
                .build();
    }

    public List<HallDto> listToDto(List<Hall> halls){
        return halls.stream().map(this::toDto).collect(Collectors.toList());
    }
}

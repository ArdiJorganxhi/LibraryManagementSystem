package dev.ardijorganxhi.librarymanagementsystem.service;

import dev.ardijorganxhi.librarymanagementsystem.entity.Hall;
import dev.ardijorganxhi.librarymanagementsystem.exception.APIException;
import dev.ardijorganxhi.librarymanagementsystem.mapper.HallMapper;
import dev.ardijorganxhi.librarymanagementsystem.model.dto.HallDto;
import dev.ardijorganxhi.librarymanagementsystem.model.enums.ErrorEnum;
import dev.ardijorganxhi.librarymanagementsystem.model.request.CreateHallRequest;
import dev.ardijorganxhi.librarymanagementsystem.model.response.HallResponse;
import dev.ardijorganxhi.librarymanagementsystem.repository.HallRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HallService {

    private final HallRepository hallRepository;
    private final HallMapper hallMapper;


    public Hall createHall(CreateHallRequest request) {
        Hall hall = hallMapper.createHall(request);
        hallRepository.save(hall);
        return hall;
    }

    public HallResponse getAllHalls(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<Hall> halls = hallRepository.findAll(pageable);
        return hallMapper.toResponse(halls);
    }

    public HallDto getHallById(Long id) {
        return hallMapper.toDto(hallRepository.findById(id).orElseThrow(() -> new APIException(ErrorEnum.HALL_NOT_FOUND)));
    }

    public HallDto enteredHall(Long id) {
        Hall hall = hallRepository.findById(id).orElseThrow(() -> new APIException(ErrorEnum.HALL_NOT_FOUND));
        hall.setEmptySeats(hall.getEmptySeats() + 1);
        return hallMapper.toDto(hall);
    }

    public HallDto exitHall(Long id) {
        Hall hall = hallRepository.findById(id).orElseThrow(() -> new APIException(ErrorEnum.HALL_NOT_FOUND));
        hall.setEmptySeats(hall.getEmptySeats() - 1);
        return hallMapper.toDto(hall);
    }

}

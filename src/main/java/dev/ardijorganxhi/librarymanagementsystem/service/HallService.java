package dev.ardijorganxhi.librarymanagementsystem.service;

import dev.ardijorganxhi.librarymanagementsystem.entity.Book;
import dev.ardijorganxhi.librarymanagementsystem.entity.Hall;
import dev.ardijorganxhi.librarymanagementsystem.mapper.HallMapper;
import dev.ardijorganxhi.librarymanagementsystem.model.dto.HallDto;
import dev.ardijorganxhi.librarymanagementsystem.model.request.CreateHallRequest;
import dev.ardijorganxhi.librarymanagementsystem.model.response.BookResponse;
import dev.ardijorganxhi.librarymanagementsystem.model.response.HallResponse;
import dev.ardijorganxhi.librarymanagementsystem.repository.HallRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HallService {

    private final HallRepository hallRepository;
    private final HallMapper hallMapper;


    public Hall createHall(CreateHallRequest request){
        Hall hall = hallMapper.createHall(request);
        hallRepository.save(hall);
        return hall;
    }
    public HallResponse getAllHalls(int pageNo, int pageSize, String sortBy, String sortDir){
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<Hall> halls = hallRepository.findAll(pageable);
        HallResponse hallResponse = hallMapper.toResponse(halls);
        return hallResponse;
    }
    public HallDto getHallById(Long id) throws Exception{
        return hallMapper.toDto(hallRepository.findById(id).orElseThrow(() -> new Exception("Hall not found!")));
    }
    public HallDto enteredHall(Long id) throws Exception{
        Hall hall = hallRepository.findById(id).orElseThrow(() -> new Exception("Hall not found!"));
        hall.setEmptySeats(hall.getEmptySeats() + 1);
        return hallMapper.toDto(hall);
    }
    public HallDto exitHall(Long id) throws Exception {
        Hall hall = hallRepository.findById(id).orElseThrow(() -> new Exception("Hall not found!"));
        hall.setEmptySeats(hall.getEmptySeats() - 1);
        return hallMapper.toDto(hall);
    }

}

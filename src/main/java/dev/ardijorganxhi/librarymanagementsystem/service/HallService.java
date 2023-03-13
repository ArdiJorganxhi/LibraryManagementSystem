package dev.ardijorganxhi.librarymanagementsystem.service;

import dev.ardijorganxhi.librarymanagementsystem.entity.Hall;
import dev.ardijorganxhi.librarymanagementsystem.mapper.HallMapper;
import dev.ardijorganxhi.librarymanagementsystem.model.request.CreateHallRequest;
import dev.ardijorganxhi.librarymanagementsystem.repository.HallRepository;
import lombok.RequiredArgsConstructor;
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
    public List<Hall> getHalls(){
        return hallRepository.findAll();
    }
    public Hall getHallById(Long id) throws Exception{
        return hallRepository.findById(id).orElseThrow(() -> new Exception("Hall not found!"));
    }
    public void enteredHall(Long id) throws Exception{
        Hall hall = getHallById(id);
        hall.setEmptySeats(hall.getEmptySeats() + 1);
    }
    public void exitHall(Long id) throws Exception {
        Hall hall = getHallById(id);
        hall.setEmptySeats(hall.getEmptySeats() - 1);
    }

}

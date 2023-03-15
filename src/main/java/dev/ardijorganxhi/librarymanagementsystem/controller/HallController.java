package dev.ardijorganxhi.librarymanagementsystem.controller;

import dev.ardijorganxhi.librarymanagementsystem.entity.Hall;
import dev.ardijorganxhi.librarymanagementsystem.model.dto.HallDto;
import dev.ardijorganxhi.librarymanagementsystem.model.request.CreateHallRequest;
import dev.ardijorganxhi.librarymanagementsystem.service.HallService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/halls")
@AllArgsConstructor
public class HallController {

    private final HallService hallService;

    @GetMapping
    public ResponseEntity<List<HallDto>> getHalls(){
        return ResponseEntity.ok(hallService.getHalls());
    }
    @PostMapping
    public ResponseEntity<Hall> createHall(@RequestBody CreateHallRequest request){
        return ResponseEntity.ok(hallService.createHall(request));
    }
    @PatchMapping("/{id}/enter")
    public ResponseEntity<HallDto> enterHall(@PathVariable Long id) throws Exception{
        return ResponseEntity.ok(hallService.enteredHall(id));
    }
    @PatchMapping("/{id}/exit")
    public ResponseEntity<HallDto> exitHall(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(hallService.exitHall(id));
    }
}

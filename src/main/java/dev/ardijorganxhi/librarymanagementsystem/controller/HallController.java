package dev.ardijorganxhi.librarymanagementsystem.controller;

import dev.ardijorganxhi.librarymanagementsystem.entity.Hall;
import dev.ardijorganxhi.librarymanagementsystem.model.dto.HallDto;
import dev.ardijorganxhi.librarymanagementsystem.model.request.CreateHallRequest;
import dev.ardijorganxhi.librarymanagementsystem.model.response.BookResponse;
import dev.ardijorganxhi.librarymanagementsystem.model.response.HallResponse;
import dev.ardijorganxhi.librarymanagementsystem.service.HallService;
import dev.ardijorganxhi.librarymanagementsystem.utils.AppConstants;
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
    public HallResponse getAllUsers(
            @RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir
    ) {
        return hallService.getAllHalls(pageNo, pageSize, sortBy, sortDir);
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

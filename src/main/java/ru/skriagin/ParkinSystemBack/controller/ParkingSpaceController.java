package ru.skriagin.ParkinSystemBack.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.skriagin.ParkinSystemBack.model.ParkingSpace;
import ru.skriagin.ParkinSystemBack.service.ParkingSpace.ParkingSpaceService;

@RestController
@RequestMapping("/parking-space")
@RequiredArgsConstructor
public class ParkingSpaceController {
    private final ParkingSpaceService service;

    @PostMapping
    public ParkingSpace create(@RequestBody ParkingSpace parkingSpace) {
        return service.create(parkingSpace);
    }

    @GetMapping("/{id}")
    public ParkingSpace getById(@PathVariable Integer id) {
        return service.getById(id);
    }

    @PutMapping
    public ParkingSpace update(@RequestBody ParkingSpace parkingSpace){
        return service.update(parkingSpace);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}

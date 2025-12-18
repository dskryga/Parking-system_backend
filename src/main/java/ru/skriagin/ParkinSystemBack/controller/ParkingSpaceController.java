package ru.skriagin.ParkinSystemBack.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.skriagin.ParkinSystemBack.model.ParkingSpace;
import ru.skriagin.ParkinSystemBack.service.ParkingSpace.ParkingSpaceService;

import java.util.Collection;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/parking-space")
@RequiredArgsConstructor
@Slf4j
public class ParkingSpaceController {
    private final ParkingSpaceService service;

    @PostMapping
    public ParkingSpace create(@RequestBody ParkingSpace parkingSpace) {
        log.info("Получен запрос на создание парковочного метса: {}", parkingSpace);
        return service.create(parkingSpace);
    }

    @GetMapping("/{id}")
    public ParkingSpace getById(@PathVariable Integer id) {
        log.info("Получен запрос на получение парковочного места с id {}", id);
        return service.getById(id);
    }

    @PutMapping
    public ParkingSpace update(@RequestBody ParkingSpace parkingSpace){
        log.info("Получен запрос на обновление парковочного места: {}", parkingSpace);
        return service.update(parkingSpace);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        log.info("Полчен запрос на удаление парковочного места с id {}", id);
        service.delete(id);
    }

    @GetMapping("/all")
    public Collection<ParkingSpace> getAll(){
        log.info("Получен запрос на получение всех парковочных мест");
        return service.getAll();
    }
}

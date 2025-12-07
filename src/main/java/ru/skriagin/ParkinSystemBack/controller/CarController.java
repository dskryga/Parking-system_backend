package ru.skriagin.ParkinSystemBack.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.skriagin.ParkinSystemBack.model.Car;
import ru.skriagin.ParkinSystemBack.service.Car.CarService;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
@RequestMapping("/car")
public class CarController {
    private final CarService carService;

    @PostMapping
    public Car create(@RequestBody Car car) {
        return carService.create(car);
    }

    @GetMapping("/{id}")
    public Car getById(@PathVariable Integer id) {
        return carService.getById(id);
    }

    @PutMapping
    public Car update(@RequestBody Car car) {
        return carService.update(car);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        carService.delete(id);
    }

    @GetMapping("/search")
    public Collection<Car> searchByNumber(@RequestParam String number) {
        return carService.searchByNumber(number);
    }
}

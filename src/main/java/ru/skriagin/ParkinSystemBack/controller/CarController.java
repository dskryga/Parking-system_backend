package ru.skriagin.ParkinSystemBack.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.skriagin.ParkinSystemBack.model.Car;
import ru.skriagin.ParkinSystemBack.service.Car.CarService;

import java.util.Collection;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
@RequestMapping("/car")
@Slf4j
public class CarController {
    private final CarService carService;

    @PostMapping
    public Car create(@RequestBody Car car) {
        log.info("Получен запрос на создание авто: {}", car);
        return carService.create(car);
    }

    @GetMapping("/{id}")
    public Car getById(@PathVariable Integer id) {
        log.info("Получен запрос на получение автомобиля с id {}", id);
        return carService.getById(id);
    }

    @PutMapping
    public Car update(@RequestBody Car car) {
        log.info("Получен запрос на обновления авто: {}", car);
        return carService.update(car);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        log.info("Получен запрос на удаление авто: {}", id);
        carService.delete(id);
    }

    @GetMapping("/search")
    public Collection<Car> searchByNumber(@RequestParam String number) {
        log.info("Получен запрос на поиск авто по номеру: {}", number);
        return carService.searchByNumber(number);
    }

    @GetMapping("/all")
    public Collection<Car> getAllCars() {
        log.info("Получен запрос на получение всех машина");
        return carService.getAll();
    }
}

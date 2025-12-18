package ru.skriagin.ParkinSystemBack.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.skriagin.ParkinSystemBack.model.CarOwner;
import ru.skriagin.ParkinSystemBack.service.CarOwner.CarOwnerService;

import java.util.Collection;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/car-owner")
@RequiredArgsConstructor
public class CarOwnerController {
    private final CarOwnerService service;

    @PostMapping
    public CarOwner create(@RequestBody CarOwner carOwner) {
        log.info("Получен запрос на создание владельца с именем: {}", carOwner.getFullName());
        return service.create(carOwner);
    }

    @GetMapping("/{id}")
    public CarOwner getById(@PathVariable Integer id) {
        log.info("Получен запрос на получение владельца с id {}", id);
        return service.getById(id);
    }

    @GetMapping("/search")
    public Collection<CarOwner> searchByName(@RequestParam String name) {
        log.info("Получен запрос на поиск владельца по имени: {}", name);
        return service.getByFullName(name);
    }

    @PutMapping
    public CarOwner update(@RequestBody CarOwner carOwner) {
        log.info("Получен запрос на обновление владельца: {}", carOwner);
        return service.update(carOwner);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        log.info("Получен запрос на удаление владельца с id {}", id);
        service.delete(id);
    }

    @GetMapping("/all")
    public Collection<CarOwner> getAll() {
        log.info("Получен запрос на получение всех клиентов");
        return service.getAll();
    }
}

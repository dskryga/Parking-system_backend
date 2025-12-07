package ru.skriagin.ParkinSystemBack.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.skriagin.ParkinSystemBack.model.CarOwner;
import ru.skriagin.ParkinSystemBack.service.CarOwner.CarOwnerService;

import java.util.Collection;

@RestController
@RequestMapping("/car-owners")
@RequiredArgsConstructor
public class CarOwnerController {
    private final CarOwnerService service;

    @PostMapping
    public CarOwner create(@RequestBody CarOwner carOwner) {
        return service.create(carOwner);
    }

    @GetMapping("/{id}")
    public CarOwner getById(@PathVariable Integer id){
        return service.getById(id);
    }

    @GetMapping("/search")
    public Collection<CarOwner> searchByName(@RequestParam String name) {
        return service.getByFullName(name);
    }

    @PutMapping
    public CarOwner update(@RequestBody CarOwner carOwner) {
        return service.update(carOwner);
    }
}

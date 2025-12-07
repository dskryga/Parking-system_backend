package ru.skriagin.ParkinSystemBack.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.skriagin.ParkinSystemBack.model.CarOwner;
import ru.skriagin.ParkinSystemBack.repository.CarOwner.CarOwnerRepository;

@RestController
@RequestMapping("/car-owners")
@RequiredArgsConstructor
public class CarOwnerController {
    private final CarOwnerRepository carOwnerRepository;
    @PostMapping
    public CarOwner create(@RequestBody CarOwner carOwner) {
        CarOwner created = carOwnerRepository.createAndReturnId(carOwner);
        return carOwner;
    }
}

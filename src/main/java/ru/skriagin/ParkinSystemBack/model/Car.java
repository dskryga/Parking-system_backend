package ru.skriagin.ParkinSystemBack.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Car {
    private int id;
    private String number;
    private CarOwner owner;
}

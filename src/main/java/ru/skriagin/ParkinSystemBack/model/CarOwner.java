package ru.skriagin.ParkinSystemBack.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class CarOwner {
    private int id;
    private String fullName;
}

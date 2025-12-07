package ru.skriagin.ParkinSystemBack.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ParkingSpace {
    private int id;
    private boolean isAvailable = true;
    private String number;
}

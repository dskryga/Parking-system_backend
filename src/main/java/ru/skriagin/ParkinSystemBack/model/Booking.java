package ru.skriagin.ParkinSystemBack.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Booking {
    private int id;
    private Car car;
    private int spaceId;
    private boolean isPaid = false;
}

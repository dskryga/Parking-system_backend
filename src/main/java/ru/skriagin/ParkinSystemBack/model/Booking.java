package ru.skriagin.ParkinSystemBack.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Booking {
    private long id;
    private int carId;
    private int parkingSpaceId;
    private boolean isPaid = false;
}

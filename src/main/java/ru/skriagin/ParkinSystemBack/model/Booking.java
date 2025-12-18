package ru.skriagin.ParkinSystemBack.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Booking {
    private long id;
    private int carId;
    private int parkingSpaceId;
    @JsonProperty("isPaid")
    private boolean isPaid = false;
}

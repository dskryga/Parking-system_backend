package ru.skriagin.ParkinSystemBack.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ParkingSpace {
    private int id;
    @JsonProperty("isAvailable")
    private boolean isAvailable = true;
    private String number;
}

package ru.skriagin.ParkinSystemBack.dto.Booking;

import lombok.Data;
import ru.skriagin.ParkinSystemBack.model.Car;
import ru.skriagin.ParkinSystemBack.model.ParkingSpace;

@Data
public class BookingDetailedResponse {
    private long id;
    private Car car;
    private ParkingSpace parkingSpace;
    private Boolean isPaid;
}

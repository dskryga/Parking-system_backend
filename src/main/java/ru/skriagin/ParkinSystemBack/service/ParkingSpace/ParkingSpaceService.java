package ru.skriagin.ParkinSystemBack.service.ParkingSpace;

import ru.skriagin.ParkinSystemBack.model.ParkingSpace;

import java.util.Collection;


public interface ParkingSpaceService {
    ParkingSpace create(ParkingSpace parkingSpace);
    ParkingSpace getById(int id);
    ParkingSpace update(ParkingSpace parkingSpace);
    void delete(int id);
    Collection<ParkingSpace> getAll();
}

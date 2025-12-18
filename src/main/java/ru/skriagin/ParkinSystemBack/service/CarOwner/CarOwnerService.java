package ru.skriagin.ParkinSystemBack.service.CarOwner;

import ru.skriagin.ParkinSystemBack.model.CarOwner;

import java.util.Collection;

public interface CarOwnerService {
    CarOwner create(CarOwner carOwner);
    CarOwner getById(int id);
    Collection<CarOwner> getByFullName(String fullName);
    CarOwner update(CarOwner carOwner);
    void delete(int id);
    Collection<CarOwner> getAll();
}

package ru.skriagin.ParkinSystemBack.service.Car;

import ru.skriagin.ParkinSystemBack.model.Car;

import java.util.Collection;

public interface CarService {
    Car create(Car car);
    Car getById(int id);
    Car update(Car car);
    void delete(int id);
    Collection<Car> searchByNumber(String number);
    Collection<Car> getAll();
}

package ru.skriagin.ParkinSystemBack.service.Car;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.skriagin.ParkinSystemBack.Exception.NotFoundException;
import ru.skriagin.ParkinSystemBack.model.Car;
import ru.skriagin.ParkinSystemBack.repository.Car.CarRepository;
import ru.skriagin.ParkinSystemBack.repository.CarOwner.CarOwnerRepository;

import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final CarOwnerRepository carOwnerRepository;

    @Override
    public Car create(Car car) {

        if (!carOwnerRepository.isExists(car.getOwner())) {
            throw new NotFoundException("Car owner not found. Id: " + car.getOwner().getId());
        }

        return carRepository.create(car);
    }

    @Override
    public Car getById(int id) {
        return carRepository.getById(id);
    }

    @Override
    public Car update(Car car) {
        return carRepository.update(car);
    }

    @Override
    public void delete(int id) {
        carRepository.delete(id);
    }

    @Override
    public Collection<Car> searchByNumber(String number) {
        return carRepository.searchByNumber(number);
    }

    @Override
    public Collection<Car> getAll() {
        return carRepository.getAll();
    }
}

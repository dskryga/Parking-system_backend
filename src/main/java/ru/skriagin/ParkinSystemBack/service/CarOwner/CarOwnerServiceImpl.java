package ru.skriagin.ParkinSystemBack.service.CarOwner;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.skriagin.ParkinSystemBack.model.CarOwner;
import ru.skriagin.ParkinSystemBack.repository.CarOwner.CarOwnerRepository;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class CarOwnerServiceImpl implements CarOwnerService{
    private final CarOwnerRepository repository;

    @Override
    public CarOwner create(CarOwner carOwner) {
        return repository.create(carOwner);
    }

    @Override
    public CarOwner getById(int id) {
        return repository.getById(id);
    }

    @Override
    public Collection<CarOwner> getByFullName(String fullName) {
        return repository.getByFullName(fullName);
    }

    @Override
    public CarOwner update(CarOwner carOwner) {
        return repository.update(carOwner);
    }
}

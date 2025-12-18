package ru.skriagin.ParkinSystemBack.service.ParkingSpace;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.skriagin.ParkinSystemBack.model.ParkingSpace;
import ru.skriagin.ParkinSystemBack.repository.ParkingSpace.ParkingSpaceRepository;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class ParkingSpaceServiceImpl implements ParkingSpaceService {

    private final ParkingSpaceRepository repository;

    @Override
    public ParkingSpace create(ParkingSpace parkingSpace) {
        return repository.create(parkingSpace);
    }

    @Override
    public ParkingSpace getById(int id) {
        return repository.getById(id);
    }

    @Override
    public ParkingSpace update(ParkingSpace parkingSpace) {
        return repository.update(parkingSpace);
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }

    @Override
    public Collection<ParkingSpace> getAll() {
        return repository.getAll();
    }
}

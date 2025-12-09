package ru.skriagin.ParkinSystemBack.service.Booking;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.skriagin.ParkinSystemBack.dto.Booking.BookingDetailedResponse;
import ru.skriagin.ParkinSystemBack.model.Booking;
import ru.skriagin.ParkinSystemBack.model.Car;
import ru.skriagin.ParkinSystemBack.model.ParkingSpace;
import ru.skriagin.ParkinSystemBack.repository.Booking.BookingRepository;
import ru.skriagin.ParkinSystemBack.repository.Car.CarRepository;
import ru.skriagin.ParkinSystemBack.repository.ParkingSpace.ParkingSpaceRepository;

import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final CarRepository carRepository;
    private final ParkingSpaceRepository parkingSpaceRepository;

    @Override
    public Booking create(Booking booking) {
        return bookingRepository.create(booking);
    }

    @Override
    public BookingDetailedResponse getBookingDetailed(long id) {
        BookingDetailedResponse detailedResponse = new BookingDetailedResponse();
        Booking booking = bookingRepository.getById(id);
        detailedResponse.setId(id);
        detailedResponse.setPaid(booking.isPaid());
        Car car = carRepository.getById(booking.getCarId());
        ParkingSpace parkingSpace = parkingSpaceRepository.getById(booking.getParkingSpaceId());
        detailedResponse.setCar(car);
        detailedResponse.setParkingSpace(parkingSpace);
        return detailedResponse;
    }

    @Override
    public Collection<Booking> getAllBookings() {
        return bookingRepository.getAll();
    }

    @Override
    public Booking update(Booking booking) {
        return bookingRepository.update(booking);
    }

    @Override
    public void delete(long id) {
        bookingRepository.delete(id);
    }


}

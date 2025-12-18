package ru.skriagin.ParkinSystemBack.service.Booking;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.skriagin.ParkinSystemBack.Exception.NotAvailableException;
import ru.skriagin.ParkinSystemBack.dto.Booking.BookingDetailedResponse;
import ru.skriagin.ParkinSystemBack.model.Booking;
import ru.skriagin.ParkinSystemBack.model.Car;
import ru.skriagin.ParkinSystemBack.model.ParkingSpace;
import ru.skriagin.ParkinSystemBack.repository.Booking.BookingRepository;
import ru.skriagin.ParkinSystemBack.repository.Car.CarRepository;
import ru.skriagin.ParkinSystemBack.repository.ParkingSpace.ParkingSpaceRepository;

import java.util.ArrayList;
import java.util.Collection;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final CarRepository carRepository;
    private final ParkingSpaceRepository parkingSpaceRepository;

    @Override
    public Booking create(Booking booking) {
        if (parkingSpaceRepository.isAvailable(booking.getParkingSpaceId())) {
            if(booking.isPaid()) {
                parkingSpaceRepository.updateAvailable(booking.getParkingSpaceId(), false);
            }
            return bookingRepository.create(booking);
        } else {
         throw new NotAvailableException("Parkins space is not available, id: " + booking.getParkingSpaceId());
        }
    }

    @Override
    public BookingDetailedResponse getBookingDetailed(long id) {
        BookingDetailedResponse detailedResponse = new BookingDetailedResponse();
        Booking booking = bookingRepository.getById(id);
        detailedResponse.setId(id);
        detailedResponse.setIsPaid(booking.isPaid());
        Car car = carRepository.getById(booking.getCarId());
        ParkingSpace parkingSpace = parkingSpaceRepository.getById(booking.getParkingSpaceId());
        detailedResponse.setCar(car);
        detailedResponse.setParkingSpace(parkingSpace);
        return detailedResponse;
    }

    @Override
    public Collection<BookingDetailedResponse> getAllBookingsDetailed() {
        Collection<BookingDetailedResponse> response = new ArrayList<>();
        Collection<Booking> shortBookings = getAllBookings();
        for(Booking b : shortBookings) {
            BookingDetailedResponse detailed = new BookingDetailedResponse();
            detailed.setId(b.getId());
            detailed.setIsPaid(b.isPaid());
            detailed.setCar(carRepository.getById(b.getCarId()));
            detailed.setParkingSpace(parkingSpaceRepository.getById(b.getParkingSpaceId()));
            response.add(detailed);
        }
        return response;
    }

    @Override
    public Collection<Booking> getAllBookings() {
        return bookingRepository.getAll();
    }

    @Override
    public Booking update(Booking booking) {
        parkingSpaceRepository.updateAvailable(booking.getParkingSpaceId(), !booking.isPaid());
        return bookingRepository.update(booking);
    }

    @Override
    public void delete(long id) {
        int spaceId = bookingRepository.getById(id).getParkingSpaceId();
        parkingSpaceRepository.updateAvailable(spaceId, true);
        bookingRepository.delete(id);
    }

    @Override
    public void togglePayment(long id, boolean isPaid) {
        bookingRepository.togglePayment(id, isPaid);
    }
}

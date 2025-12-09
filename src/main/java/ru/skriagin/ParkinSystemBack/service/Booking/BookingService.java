package ru.skriagin.ParkinSystemBack.service.Booking;

import ru.skriagin.ParkinSystemBack.dto.Booking.BookingDetailedResponse;
import ru.skriagin.ParkinSystemBack.model.Booking;

import java.util.Collection;

public interface BookingService {
    Booking create (Booking booking);
    BookingDetailedResponse getBookingDetailed(long id);
    Collection<Booking> getAllBookings();
    Booking update(Booking booking);
    void delete(long id);
}

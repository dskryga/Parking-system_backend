package ru.skriagin.ParkinSystemBack.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.skriagin.ParkinSystemBack.dto.Booking.BookingDetailedResponse;
import ru.skriagin.ParkinSystemBack.model.Booking;
import ru.skriagin.ParkinSystemBack.service.Booking.BookingService;

import java.util.Collection;

@RestController
@RequestMapping("/booking")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping
    public Booking create(@RequestBody Booking booking) {
        return bookingService.create(booking);
    }

    @GetMapping("/all")
    public Collection<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @GetMapping("/{id}")
    public BookingDetailedResponse getBookingDetailed(@PathVariable Long id) {
        return bookingService.getBookingDetailed(id);
    }

    @PutMapping
    public Booking update(@RequestBody Booking booking) {
        return bookingService.update(booking);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        bookingService.delete(id);
    }
}

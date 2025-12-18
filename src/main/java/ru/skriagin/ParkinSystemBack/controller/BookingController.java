package ru.skriagin.ParkinSystemBack.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.skriagin.ParkinSystemBack.dto.Booking.BookingDetailedResponse;
import ru.skriagin.ParkinSystemBack.dto.Booking.PaymentUpdateRequest;
import ru.skriagin.ParkinSystemBack.model.Booking;
import ru.skriagin.ParkinSystemBack.service.Booking.BookingService;

import java.util.Collection;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/booking")
@RequiredArgsConstructor
@Slf4j
public class BookingController {

    private final BookingService bookingService;

    @PostMapping
    public Booking create(@RequestBody Booking booking) {
        log.info("Получен запрос на создание бронирования: {}", booking);
        return bookingService.create(booking);
    }

    @GetMapping("/all")
    public Collection<Booking> getAllBookings() {
        log.info("Получен запрос на получение всех бронирований сокращенно");
        return bookingService.getAllBookings();
    }

    @GetMapping("/all/detailed")
    public Collection<BookingDetailedResponse> getAllBookingsDetailed() {
        log.info("Получен запрос на получение всех бронирований детально");
        return bookingService.getAllBookingsDetailed();
    }

    @GetMapping("/{id}")
    public BookingDetailedResponse getBookingDetailed(@PathVariable Long id) {
        log.info("Получен запрос на получение деталей бронирования с id {}", id);
        return bookingService.getBookingDetailed(id);
    }

    @PutMapping
    public Booking update(@RequestBody Booking booking) {
        log.info("Получен запрос на обновление бронирования {}", booking);
        return bookingService.update(booking);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        log.info("Получен запрос на удаления бронирования с id {}", id);
        bookingService.delete(id);
    }

    @PatchMapping("/{id}/payment")
    public void togglePayment(@PathVariable Long id, @RequestBody PaymentUpdateRequest payment) {
        log.info("Получен запрос на изменение статуса оплаты для бронирования с id {} на {}", id, payment.getIsPaid());
        bookingService.togglePayment(id, payment.getIsPaid());
    }
}

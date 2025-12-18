package ru.skriagin.ParkinSystemBack.repository.Booking;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.skriagin.ParkinSystemBack.Exception.NotFoundException;
import ru.skriagin.ParkinSystemBack.model.Booking;
import ru.skriagin.ParkinSystemBack.repository.Base.BaseRepository;

import java.util.Collection;
import java.util.Optional;

@Repository
public class BookingRepository extends BaseRepository<Booking> {

    private static final String CREATE_QUERY = "INSERT into bookings(car_id, space_id, is_Paid) VALUES(?, ?, ?) returning id;";
    private static final String UPDATE_QUERY = "UPDATE bookings SET car_id = ?, space_id = ?, is_paid = ? WHERE id = ?;";
    private static final String UPDATE_PAYMENT_QUERY = "UPDATE bookings SET is_paid = ? WHERE id = ?;";
    private static final String GET_BY_ID_QUERY = "SELECT * FROM bookings WHERE id = ?;";
    private static final String DELETE_QUERY = "DELETE FROM bookings WHERE id = ?;";
    private static final String GET_ALL_QUERY = "SELECT * FROM bookings;";

    public BookingRepository(JdbcTemplate jdbcTemplate, RowMapper<Booking> rowMapper) {
        super(jdbcTemplate, rowMapper);
    }

    public Booking create(Booking booking) {
        Long id = insertAndReturnId(CREATE_QUERY, Long.class, booking.getCarId(), booking.getParkingSpaceId(), booking.isPaid());
        if (id == null) return null;
        booking.setId(id);
        return booking;
    }

    public Booking getById(long id) {
        Optional<Booking> bookingOpt = getOne(GET_BY_ID_QUERY, id);
        return bookingOpt.orElseThrow(() -> new NotFoundException("Booking not found. Id: " + id));
    }

    public Booking update(Booking booking) {
        super.update(UPDATE_QUERY, booking.getCarId(), booking.getParkingSpaceId(), booking.isPaid(), booking.getId());
        return getById(booking.getId());
    }

    public void delete(long id) {
        super.delete(DELETE_QUERY, id);
    }

    public Collection<Booking> getAll() {
        return getMany(GET_ALL_QUERY);
    }

    public void togglePayment(long id, boolean isPaid) {
        super.update(UPDATE_PAYMENT_QUERY,isPaid, id);
        System.out.println("In repo" + isPaid);
    }

}

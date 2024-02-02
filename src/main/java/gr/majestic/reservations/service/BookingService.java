package gr.majestic.reservations.service;

import gr.majestic.reservations.dto.BookingDto;
import gr.majestic.reservations.model.Booking;

import java.util.List;

public interface BookingService extends GeneralService<Booking, Long> {
    Booking createBookingDto(BookingDto bookingDto);

    Booking updateBookingDto(long bookingId, BookingDto bookingDto);

    List<Booking> findAllBookingsForCustomer(long customerId);
}

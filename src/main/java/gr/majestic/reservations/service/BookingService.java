package gr.majestic.reservations.service;

import gr.majestic.reservations.dto.BookingDto;
import gr.majestic.reservations.dto.ResponseApi;
import gr.majestic.reservations.model.Booking;

import java.util.List;

public interface BookingService extends GeneralService<Booking, Long> {
    ResponseApi<Booking> createBookingDto(BookingDto bookingDto);
    BookingDto updateBookingDto(Long modelId, BookingDto newModel);


    List<BookingDto> readBookingDto();
    List<BookingDto> findAllBookingsForCustomer(long customerId);
}

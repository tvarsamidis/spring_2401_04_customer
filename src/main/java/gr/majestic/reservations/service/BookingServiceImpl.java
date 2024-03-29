package gr.majestic.reservations.service;

import gr.majestic.reservations.dto.BookingDto;
import gr.majestic.reservations.exception.UpdateBookingException;
import gr.majestic.reservations.model.Booking;
import gr.majestic.reservations.model.Customer;
import gr.majestic.reservations.model.Room;
import gr.majestic.reservations.repository.BookingRepository;
import gr.majestic.reservations.repository.CustomerRepository;
import gr.majestic.reservations.repository.RoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final CustomerRepository customerRepository;
    private final RoomRepository roomRepository;

    @Override
    public Booking create(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public List<Booking> read() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking read(Long modelId) {
        return null;
    }

    /**
     * This method throws an exception because you are not allowed to update a booking.
     *
     * @param modelId  ignored
     * @param newModel ignored
     * @return does not return a value because it throws an exception
     * @throws gr.majestic.reservations.exception.UpdateBookingException always
     */
    @Override
    public Booking update(Long modelId, Booking newModel) {
        throw new UpdateBookingException("To change a booking, cancel and create a new one");
    }

    @Override
    public Booking delete(Long modelId) {
        return null;
    }

    @Override
    public Booking createBookingDto(BookingDto bookingDto) {
        Customer customer = customerRepository.findById(bookingDto.getCustomerId()).get();
        Room room = roomRepository.findById(bookingDto.getRoomId()).get();
        Booking booking = Booking.builder()
                // .id() this will be autogenerated
                .customer(customer)
                .room(room)
                .checkInDate(bookingDto.getCheckInDate())
                .checkOutDate(bookingDto.getCheckOutDate())
                .build();
        Booking storedBooking = create(booking);
        return storedBooking;
    }

    @Override
    public Booking updateBookingDto(long bookingId, BookingDto bookingDto) {
        return update(bookingId, null);
    }

    @Override
    public List<Booking> findAllBookingsForCustomer(long customerId) {
        return null;
    }
}

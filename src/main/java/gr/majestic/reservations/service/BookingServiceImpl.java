package gr.majestic.reservations.service;

import gr.majestic.reservations.model.Booking;
import gr.majestic.reservations.repository.BookingRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;

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

    @Override
    public Booking update(Long modelId, Booking newModel) {
        return null;
    }

    @Override
    public Booking delete(Long modelId) {
        return null;
    }
}

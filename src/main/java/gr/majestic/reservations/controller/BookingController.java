package gr.majestic.reservations.controller;

import gr.majestic.reservations.dto.BookingDto;
import gr.majestic.reservations.model.Booking;
import gr.majestic.reservations.service.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/booking")
public class BookingController {

    private final BookingService bookingService;

    @PostMapping("/create")
    public Booking createBooking(@RequestBody BookingDto bookingDto) {
        Booking savedBooking = bookingService.createBookingDto(bookingDto);
        return savedBooking;
    }


    @GetMapping("") // this is just a test name, it will change next
    public List<Booking> findAll() {
        return bookingService.read();
    }

    @PutMapping("/{bookingId}")
    public Booking updateBooking(@PathVariable long bookingId, @RequestBody BookingDto bookingDto) {
        return bookingService.updateBookingDto(bookingId, bookingDto);
    }

}

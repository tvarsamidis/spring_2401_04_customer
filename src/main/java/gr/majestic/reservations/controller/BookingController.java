package gr.majestic.reservations.controller;

import gr.majestic.reservations.model.Booking;
import gr.majestic.reservations.service.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    public Booking createBooking(@RequestBody Booking booking) {
        Booking savedBooking = bookingService.create(booking);
        return savedBooking;
    }


    @GetMapping("") // this is just a test name, it will change next
    public List<Booking> findAll() {
        return bookingService.read();
    }


}

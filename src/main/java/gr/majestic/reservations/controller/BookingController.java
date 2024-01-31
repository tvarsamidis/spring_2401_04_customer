package gr.majestic.reservations.controller;

import gr.majestic.reservations.model.Booking;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/booking")
public class BookingController {
    @GetMapping("/allbookings") // this is just a test name, it will change next
    public List<Booking> findAll() {
        return null;
    }
}

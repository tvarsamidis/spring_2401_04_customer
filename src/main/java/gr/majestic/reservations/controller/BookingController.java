package gr.majestic.reservations.controller;

import gr.majestic.reservations.configuration.HotelMapper;
import gr.majestic.reservations.dto.BookingDto;
import gr.majestic.reservations.dto.ResponseApi;
import gr.majestic.reservations.model.Booking;
import gr.majestic.reservations.service.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
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

    private final HotelMapper mapper;
    @PostMapping("/create")
    public ResponseApi<BookingDto> createBooking(@RequestBody BookingDto bookingDto) {
        Booking booking = bookingService.createBookingDto(bookingDto).getData();
        ResponseApi<BookingDto> result =  new ResponseApi<>();
        result.setData(mapper.bookingMappingBookingDto(booking));

        return   result;
    }


    @GetMapping("") // this is just a test name, it will change next
    public ResponseApi<List<BookingDto>> findAll() {
       long startTime = System.currentTimeMillis();
        var resultData = bookingService.readBookingDto();
       long endTime = System.currentTimeMillis();
         long elapsedTime =   endTime-startTime;

        ResponseApi<List<BookingDto>> result = new
                ResponseApi<List<BookingDto>>(resultData,0, "elapsed time "+ elapsedTime);
        return result;
    }

    @PutMapping("/{bookingId}")
    public BookingDto updateBooking(@PathVariable long bookingId, @RequestBody BookingDto bookingDto) {
        return bookingService.updateBookingDto(bookingId, bookingDto);
    }
    @GetMapping("{customerId}") // this is just a test name, it will change next
    public ResponseApi<List<BookingDto>> findByCustomer(@PathVariable long customerId) {
        long startTime = System.currentTimeMillis();
        var resultData = bookingService.findAllBookingsForCustomer(customerId);

        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime-startTime;

        ResponseApi<List<BookingDto>> result = new
                ResponseApi<List<BookingDto>>(resultData,0, "elapsed time "+ elapsedTime);
        return result;

    }
}

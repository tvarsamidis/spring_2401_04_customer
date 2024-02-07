package gr.majestic.reservations.dto;

import gr.majestic.reservations.model.Customer;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.print.Book;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class CustomerDto {
    private long id;
    private String name;
    private String email;
    private LocalDate registrationDate;
    private List<BookingDto> bookings;
}

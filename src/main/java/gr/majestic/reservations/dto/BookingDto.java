package gr.majestic.reservations.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BookingDto {
    private long customerId;
    private long roomId;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
}

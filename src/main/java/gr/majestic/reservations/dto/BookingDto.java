package gr.majestic.reservations.dto;

import lombok.Data;

import java.time.LocalDate;


public record BookingDto (
        long bookingId,
        long customerId,
        String customerName,
        long roomId,
        LocalDate checkInDate,
        LocalDate checkOutDate)
{}

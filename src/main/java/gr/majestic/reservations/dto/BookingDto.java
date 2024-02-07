package gr.majestic.reservations.dto;

import lombok.Data;

import java.time.LocalDate;


public record BookingDto (
        long customerId,
        long roomId,
        LocalDate checkInDate,
        LocalDate checkOutDate)
{}

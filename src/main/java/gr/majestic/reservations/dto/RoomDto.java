package gr.majestic.reservations.dto;

import java.math.BigDecimal;

public record RoomDto (
        int id,
         String name,
         int floorNumber,
         int guestCount,
         BigDecimal price)  { }

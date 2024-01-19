package gr.majestic.reservations.model;

import lombok.Data;

@Data
public class Room {
    private int id;
    private String number;
    private int floorNumber;
    private int bedCount;
}

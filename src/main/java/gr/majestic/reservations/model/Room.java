package gr.majestic.reservations.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Room {
    @Id
    private int id;
    private String number;
    private int floorNumber;
    private int bedCount;
}

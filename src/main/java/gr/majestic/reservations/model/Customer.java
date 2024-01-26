package gr.majestic.reservations.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.sql.Date;

@Data
@Entity
public class Customer {
    @Id
    private long id;
    private String name;
    private String email;
    private Date registrationDate;
}

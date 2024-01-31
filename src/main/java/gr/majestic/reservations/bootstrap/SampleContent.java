package gr.majestic.reservations.bootstrap;


import gr.majestic.reservations.model.Customer;
import gr.majestic.reservations.model.Room;
import gr.majestic.reservations.service.CustomerService;
import gr.majestic.reservations.service.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;

@Component
@AllArgsConstructor
public class SampleContent implements CommandLineRunner {
    private final CustomerService customerService;
    private final RoomService roomService;

    @Override
    public void run(String... args) throws Exception {


        Customer customer1 = new Customer();
        customer1.setName("John Smith");
        customer1.setEmail("john.smith@johnsmith.com");
        customer1.setRegistrationDate(LocalDate.of(2024, Month.JANUARY, 24));
        customer1 = customerService.create(customer1);

        Customer customer2 = new Customer();
        customer2.setName("Anne Gray");
        customer2.setEmail("anne.gray@annegray.com");
        customer2.setRegistrationDate(LocalDate.parse("2023-04-22"));
        customer2 = customerService.create(customer2);

        Room room1 = new Room();
        room1.setPrice(0.1 + 0.2); // room costs 0.3 bitcoins per day
        room1.setName("A101");
        room1.setGuestCount(4);
        room1.setFloorNumber(1);
        room1 = roomService.create(room1);
    }
}

package gr.majestic.reservations.bootstrap;


import gr.majestic.reservations.configuration.CustomerMapper;
import gr.majestic.reservations.dto.BookingDto;
import gr.majestic.reservations.model.Booking;
import gr.majestic.reservations.model.Customer;
import gr.majestic.reservations.model.Room;
import gr.majestic.reservations.service.BookingService;
import gr.majestic.reservations.service.CustomerService;
import gr.majestic.reservations.service.GeneralService;
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
    private final GeneralService<Room, Long> roomService;
    private final GeneralService<Customer, Long> customerService;
    private final BookingService bookingService;
    private final CustomerMapper customerMapper;
    @Override
    public void run(String... args) {
        Customer customer1 = createCustomer("John Smith", "john.smith@johnsmith.com", "2024-01-13");
        Customer customer2 = createCustomer("Anne Gray", "anne.gray@annegray.com", "2023-11-17");

        Room room1 = createRoom("A101", "100.05", 4, 1);
        Room room2 = createRoom("A103", "88.00", 3, 1);
        Room room3 = createRoom("Junior Suite", "250.00", 6, 1);


        bookingService.createBookingDto(
                customerMapper.bookingMappingBookingDto(Booking.builder()
                        .customer(customer1)
                        .room(room1)
                        .checkInDate(LocalDate.parse("2024-02-21"))
                        .checkOutDate(LocalDate.parse("2024-02-22"))
                        .build())
        );

        bookingService.createBookingDto(
                customerMapper.bookingMappingBookingDto(Booking.builder()
                        .customer(customer2)
                        .room(room1)
                        .checkInDate(LocalDate.parse("2024-01-31"))
                        .checkOutDate(LocalDate.parse("2024-02-01"))
                        .build())
        );

        bookingService.createBookingDto(
                customerMapper.bookingMappingBookingDto(Booking.builder()
                        .customer(customer2)
                        .room(room2)
                        .checkInDate(LocalDate.parse("2024-01-31"))
                        .checkOutDate(LocalDate.parse("2024-02-01"))
                        .build())
        );

    }


    private Room createRoom(String name, String price, int guestCount, int floorNumber) {
        Room room = new Room();
        room.setName(name);
        room.setPrice(new BigDecimal(price));
        room.setGuestCount(guestCount);
        room.setFloorNumber(floorNumber);
        return roomService.create(room);
    }

    private Customer createCustomer(String name, String email, String registrationDate) {
        Customer customer = new Customer();
        customer.setName(name);
        customer.setEmail(email);
        customer.setRegistrationDate(LocalDate.parse(registrationDate));
        return customerService.create(customer);
    }}

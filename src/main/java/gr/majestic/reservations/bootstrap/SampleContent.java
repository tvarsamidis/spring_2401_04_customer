package gr.majestic.reservations.bootstrap;


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

    @Override
    public void run(String... args) {
        Customer customer1 = createCustomer("John Smith", "john.smith@johnsmith.com", "2024-01-13");
        Customer customer2 = createCustomer("Anne Gray", "anne.gray@annegray.com", "2023-11-17");

        Room room1 = createRoom("A101", "100.05", 4, 1);
        Room room2 = createRoom("A103", "88.00", 3, 1);
        Room room3 = createRoom("Junior Suite", "250.00", 6, 1);

        Booking booking1 = createBookingDto(customer1, room1, "2024-02-21", "2024-02-25");
        Booking booking2 = createBookingDto(customer2, room3, "2024-02-27", "2024-03-11");
        Booking booking3 = createBookingDto(customer2, room2, "2024-02-27", "2024-03-11");
    }

    private Booking createBookingDto(Customer customer, Room room, String checkInDate, String checkOutDate) {
        BookingDto bookingDto = new BookingDto();
        bookingDto.setCustomerId(customer.getId());
        bookingDto.setRoomId(room.getId());
        bookingDto.setCheckInDate(LocalDate.parse(checkInDate));
        bookingDto.setCheckOutDate(LocalDate.parse(checkOutDate));
        return bookingService.createBookingDto(bookingDto);
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

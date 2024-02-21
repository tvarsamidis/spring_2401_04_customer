package gr.majestic.reservations.bootstrap;


import gr.majestic.reservations.configuration.HotelMapper;
import gr.majestic.reservations.model.Booking;
import gr.majestic.reservations.model.Customer;
import gr.majestic.reservations.model.Room;
import gr.majestic.reservations.service.BookingService;
import gr.majestic.reservations.service.GeneralService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

@Component
@AllArgsConstructor
public class SampleContent implements CommandLineRunner {
    private final GeneralService<Room, Long> roomService;
    private final GeneralService<Customer, Long> customerService;
    private final BookingService bookingService;
    private final HotelMapper hotelMapper;

    protected final Logger logger = LoggerFactory.getLogger(getClass());
    @Override
    public void run(String... args) {
        logger.trace("-----------------Tracing bootstrap");
        logger.debug("-----------------Debug in bootstrap");
        logger.info("------------------Info--bootstrap create has started");
        logger.warn("-----------------Warning in bootstrap");
        logger.error("-----------------Error in bootstrap");


        Customer customer1 = createCustomer("John Smith", "john.smith@johnsmith.com", "2024-01-13");
        Customer customer2 = createCustomer("Anne Gray", "anne.gray@annegray.com", "2023-11-17");

     createCustomer("John Smith1", "john.smith@johnsmith.com", "2024-01-13");
         createCustomer("Anne Gray1", "anne.gray@annegray.com", "2023-11-17");

         createCustomer("John Smith2", "john.smith@johnsmith.com", "2024-01-13");
          createCustomer("Anne Gray2", "anne.gray@annegray.com", "2023-11-17");



        Room room1 = createRoom("A101", "100.05", 4, 1);
        Room room2 = createRoom("A103", "88.00", 3, 1);
        Room room3 = createRoom("Junior Suite", "250.00", 6, 1);


        bookingService.createBookingDto(
                hotelMapper.bookingMappingBookingDto(Booking.builder()
                        .customer(customer1)
                        .room(room1)
                        .checkInDate(LocalDate.parse("2024-02-21"))
                        .checkOutDate(LocalDate.parse("2024-02-22"))
                        .build())
        );

        bookingService.createBookingDto(
                hotelMapper.bookingMappingBookingDto(Booking.builder()
                        .customer(customer2)
                        .room(room1)
                        .checkInDate(LocalDate.parse("2024-01-31"))
                        .checkOutDate(LocalDate.parse("2024-02-01"))
                        .build())
        );

        bookingService.createBookingDto(
                hotelMapper.bookingMappingBookingDto(Booking.builder()
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

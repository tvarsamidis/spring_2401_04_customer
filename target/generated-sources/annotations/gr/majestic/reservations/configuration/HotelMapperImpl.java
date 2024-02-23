package gr.majestic.reservations.configuration;

import gr.majestic.reservations.dto.BookingDto;
import gr.majestic.reservations.dto.CustomerDto;
import gr.majestic.reservations.dto.RoomDto;
import gr.majestic.reservations.model.Booking;
import gr.majestic.reservations.model.Customer;
import gr.majestic.reservations.model.Room;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-23T12:51:32+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class HotelMapperImpl implements HotelMapper {

    @Override
    public CustomerDto customerMappingCustomerDto(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerDto customerDto = new CustomerDto();

        customerDto.setId( customer.getId() );
        customerDto.setName( customer.getName() );
        customerDto.setEmail( customer.getEmail() );
        customerDto.setRegistrationDate( customer.getRegistrationDate() );
        customerDto.setBookings( bookingListToBookingDtoList( customer.getBookings() ) );

        return customerDto;
    }

    @Override
    public BookingDto bookingMappingBookingDto(Booking booking) {
        if ( booking == null ) {
            return null;
        }

        long customerId = 0L;
        long roomId = 0L;
        long bookingId = 0L;
        String customerName = null;
        LocalDate checkInDate = null;
        LocalDate checkOutDate = null;

        customerId = bookingCustomerId( booking );
        roomId = bookingRoomId( booking );
        bookingId = booking.getId();
        customerName = bookingCustomerName( booking );
        checkInDate = booking.getCheckInDate();
        checkOutDate = booking.getCheckOutDate();

        BookingDto bookingDto = new BookingDto( bookingId, customerId, customerName, roomId, checkInDate, checkOutDate );

        return bookingDto;
    }

    @Override
    public RoomDto roomMappingRoomDto(Room room) {
        if ( room == null ) {
            return null;
        }

        int id = 0;
        String name = null;
        int floorNumber = 0;
        int guestCount = 0;
        BigDecimal price = null;

        id = room.getId();
        name = room.getName();
        floorNumber = room.getFloorNumber();
        guestCount = room.getGuestCount();
        price = room.getPrice();

        RoomDto roomDto = new RoomDto( id, name, floorNumber, guestCount, price );

        return roomDto;
    }

    protected List<BookingDto> bookingListToBookingDtoList(List<Booking> list) {
        if ( list == null ) {
            return null;
        }

        List<BookingDto> list1 = new ArrayList<BookingDto>( list.size() );
        for ( Booking booking : list ) {
            list1.add( bookingMappingBookingDto( booking ) );
        }

        return list1;
    }

    private long bookingCustomerId(Booking booking) {
        if ( booking == null ) {
            return 0L;
        }
        Customer customer = booking.getCustomer();
        if ( customer == null ) {
            return 0L;
        }
        long id = customer.getId();
        return id;
    }

    private int bookingRoomId(Booking booking) {
        if ( booking == null ) {
            return 0;
        }
        Room room = booking.getRoom();
        if ( room == null ) {
            return 0;
        }
        int id = room.getId();
        return id;
    }

    private String bookingCustomerName(Booking booking) {
        if ( booking == null ) {
            return null;
        }
        Customer customer = booking.getCustomer();
        if ( customer == null ) {
            return null;
        }
        String name = customer.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }
}

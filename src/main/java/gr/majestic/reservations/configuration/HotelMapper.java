package gr.majestic.reservations.configuration;


import gr.majestic.reservations.dto.BookingDto;
import gr.majestic.reservations.dto.CustomerDto;
import gr.majestic.reservations.dto.RoomDto;
import gr.majestic.reservations.model.Booking;
import gr.majestic.reservations.model.Customer;
import gr.majestic.reservations.model.Room;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface HotelMapper {


    CustomerDto customerMappingCustomerDto(Customer customer);

    @Mapping (source="customer.id", target="customerId")
    @Mapping (source="room.id", target="roomId")
    BookingDto bookingMappingBookingDto(Booking booking);

    RoomDto roomMappingRoomDto(Room room);
}

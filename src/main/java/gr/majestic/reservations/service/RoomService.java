package gr.majestic.reservations.service;

import gr.majestic.reservations.model.Booking;
import gr.majestic.reservations.model.Room;

import java.util.List;

public interface RoomService extends GeneralService<Room, Long> {
    List<Room> findAllRoomsForGuestCount(int guestCount);
}

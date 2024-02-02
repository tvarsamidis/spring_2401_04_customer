package gr.majestic.reservations.service;

import gr.majestic.reservations.model.Booking;
import gr.majestic.reservations.model.Room;
import gr.majestic.reservations.repository.RoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    @Override
    public Room create(Room room) {
        // room.setId(12345);
        Room newRoom = roomRepository.save(room);
        // System.out.println(room.getId());
        return newRoom;
    }

    @Override
    public List<Room> read() {
        return roomRepository.findAll();
    }

    @Override
    public Room read(Long roomId) {
        return roomRepository.findById(roomId).get();
    }


    // JPA operations:   Optional.isPresent, Optional.isEmpty, Exception
    //                   result != null,      result == null,   Exception

    @Override
    public Room update(Long roomId, Room newRoom) {
        Room currentRoom = read(roomId);
        if (currentRoom == null) {
            return null;
        }
        newRoom.setId(currentRoom.getId()); //
        Room updatedRoom = roomRepository.save(newRoom);
        return updatedRoom;
    }

    @Override
    public Room delete(Long roomId) {
        Room room = read(roomId);
        if (room == null) {
            return null;
        }
        roomRepository.delete(room);
        return room;
    }


    @Override
    public List<Room> findAllRoomsForGuestCount(int guestCount) {
        return roomRepository.findByGuestCountGreaterThanEqual(guestCount);
    }
}

package gr.majestic.reservations.service;

import gr.majestic.reservations.model.Room;

import java.util.List;

public interface RoomService {
    Room createRoom(Room room);
    List<Room> readRoom();
    Room readRoom(int roomId);
    Room updateRoom(int roomId, Room newRoom);
    boolean deleteRoom(int roomId);
}

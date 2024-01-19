package gr.majestic.reservations.service;

import gr.majestic.reservations.model.Room;

import java.util.ArrayList;
import java.util.List;

public class RoomServiceImpl implements RoomService {

    private List<Room> rooms = new ArrayList<>();
    private int nextRoomId = 1;

    @Override
    public Room createRoom(Room room) {
        rooms.add(room);
        room.setId(nextRoomId);
        nextRoomId++;
        return room;
    }

    @Override
    public List<Room> readRoom() {
        return null;
    }

    @Override
    public Room readRoom(int roomId) {
        return null;
    }

    @Override
    public Room updateRoom(int roomId, Room newRoomValues) {
        return null;
    }

    @Override
    public boolean deleteRoom(int roomId) {
        return false;
    }
}

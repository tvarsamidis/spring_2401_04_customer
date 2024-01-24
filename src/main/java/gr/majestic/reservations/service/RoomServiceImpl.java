package gr.majestic.reservations.service;

import gr.majestic.reservations.model.Room;

import java.util.ArrayList;
import java.util.List;

public class RoomServiceImpl implements RoomService {

    private List<Room> rooms = new ArrayList<>();

    @Override
    public Room createRoom(Room room) {
        rooms.add(room);
        room.setId(rooms.size() - 1);
        return room;
    }

    @Override
    public List<Room> readRoom() {
        return rooms;
    }

    @Override
    public Room readRoom(int roomId) {
        return rooms.get(roomId);
    }

    @Override
    public Room updateRoom(int roomId, Room newRoom) {
        Room currentRoom = readRoom(roomId);
        newRoom.setId(currentRoom.getId());
        rooms.set(newRoom.getId(), newRoom);
        return newRoom;
    }

    @Override
    public boolean deleteRoom(int roomId) {
        if (roomId >= rooms.size() || rooms.get(roomId) == null) {
            return false;
        }
        rooms.set(roomId, null);
        return true;
    }
}

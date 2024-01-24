package gr.majestic.reservations.controller;


import gr.majestic.reservations.model.Room;
import gr.majestic.reservations.service.RoomService;
import gr.majestic.reservations.service.RoomServiceImpl;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {

    private RoomService roomService = new RoomServiceImpl();

    // CRUD
    // Create Read Update Delete

    @PostMapping("/create")
    public Room createRoom(@RequestBody Room room) {
        // save data
        return roomService.createRoom(room);
    }

    @GetMapping()
    public List<Room> readRoom() {
        return roomService.readRoom();
    }

    @GetMapping("/{roomId}")
    public Room getRoom(@PathVariable int roomId) {
        return roomService.readRoom(roomId);
    }

    // Room updateRoom(int roomId, Room newRoomValues);
    @PutMapping("/{roomId}")
    public Room updateRoom(@PathVariable int roomId, @RequestBody Room newRoom) {
        return roomService.updateRoom(roomId, newRoom);
    }

    //    boolean deleteRoom(int roomId);
    @DeleteMapping("/{roomId}")
    public boolean deleteRoom(@PathVariable int roomId) {
        return roomService.deleteRoom(roomId);
    }
}

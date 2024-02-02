package gr.majestic.reservations.controller;


import gr.majestic.reservations.model.Booking;
import gr.majestic.reservations.model.Room;
import gr.majestic.reservations.service.GeneralService;
import gr.majestic.reservations.service.RoomService;
import gr.majestic.reservations.service.RoomService;
import gr.majestic.reservations.service.RoomServiceImpl;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class RoomController {

    private RoomService roomService;

    // CRUD
    // Create Read Update Delete

    @PostMapping("/create")
    public Room createRoom(@RequestBody Room room) {
        // save data
        return roomService.create(room);
    }

    @GetMapping()
    public List<Room> readRoom() {
        return roomService.read();
    }

    @GetMapping("/{roomId}")
    public Room getRoom(@PathVariable long roomId) {
        return roomService.read(roomId);
    }

    // Room updateRoom(int roomId, Room newRoomValues);
    @PutMapping("/{roomId}")
    public Room updateRoom(@PathVariable long roomId, @RequestBody Room newRoom) {
        return roomService.update(roomId, newRoom);
    }

    //    boolean deleteRoom(int roomId);
    @DeleteMapping("/{roomId}")
    public Room deleteRoom(@PathVariable long roomId) {
        return roomService.delete(roomId);
    }

    @GetMapping("/guests/{guestCount}")
    public List<Room> findAllRoomsForGuestCount(@PathVariable int guestCount) {
        return roomService.findAllRoomsForGuestCount(guestCount);
    }


}

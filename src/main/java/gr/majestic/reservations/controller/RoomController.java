package gr.majestic.reservations.controller;


import gr.majestic.reservations.model.Room;
import gr.majestic.reservations.service.RoomService;
import gr.majestic.reservations.service.RoomServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/create")
    public String createRoom() {
        return "GET is not supported for /create";
    }


}

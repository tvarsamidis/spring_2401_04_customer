package gr.majestic.reservations.repository;

import gr.majestic.reservations.model.Booking;
import gr.majestic.reservations.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    List<Room> findByGuestCountGreaterThanEqual(Integer guestCount);
    List<Room> findByFloorNumberIsBetween(Integer starting, Integer ending);

}

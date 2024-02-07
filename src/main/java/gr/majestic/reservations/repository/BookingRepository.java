package gr.majestic.reservations.repository;

import gr.majestic.reservations.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    @Query("""
        select b 
        from Booking b 
        where b.customer.id= :customerId
        """)
    List<Booking> getBookingByCustomerId(Long customerId);
}

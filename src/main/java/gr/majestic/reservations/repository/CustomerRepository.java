package gr.majestic.reservations.repository;

import gr.majestic.reservations.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {


    List<Customer> findCustomerByNameContainingAndEmailContaining(String name, String email);

    @Query ("""
            SELECT c FROM Customer c 
            WHERE c.name like CONCAT('%', :name, '%') 
            and c.email like CONCAT('%', :email, '%') 
            and year(c.registrationDate) = :year 
            """)
    List<Customer> findCustomersByNameEmailYear(String name, String email, String year);
}

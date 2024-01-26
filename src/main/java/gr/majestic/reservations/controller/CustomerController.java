package gr.majestic.reservations.controller;

import gr.majestic.reservations.model.Customer;
import gr.majestic.reservations.service.CustomerService;
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
@RequestMapping("/customer")
@AllArgsConstructor
public class CustomerController {
    
    private final CustomerService customerService;
    // CRUD
    // Create Read Update Delete

    @PostMapping("/create")
    public Customer createCustomer(@RequestBody Customer customer) {
        // save data
        return customerService.create(customer);
    }

    @GetMapping()
    public List<Customer> readCustomer() {
        return customerService.read();
    }

    @GetMapping("/{customerId}")
    public Customer getCustomer(@PathVariable long customerId) {
        return customerService.read(customerId);
    }

    // Customer updateCustomer(int customerId, Customer newCustomerValues);
    @PutMapping("/{customerId}")
    public Customer updateCustomer(@PathVariable long customerId, @RequestBody Customer newCustomer) {
        return customerService.update(customerId, newCustomer);
    }

    //    boolean deleteCustomer(int customerId);
    @DeleteMapping("/{customerId}")
    public boolean deleteCustomer(@PathVariable long customerId) {
        return customerService.delete(customerId);
    }


}

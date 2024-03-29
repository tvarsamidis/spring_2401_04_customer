package gr.majestic.reservations.service;

import gr.majestic.reservations.exception.NoCustomerUpdateException;
import gr.majestic.reservations.model.Customer;
import gr.majestic.reservations.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public Customer create(final Customer customer) {
        customerRepository.save(customer);
        return customer;
    }

    @Override
    public List<Customer> read() {
        return customerRepository.findAll();
    }

    @Override
    public Customer read(final Long customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        return customer.get();
    }

    @Override
    public Customer update(Long customerId, Customer newCustomer) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        if (customer.isEmpty()) {
            return null;
        }
        Customer currentCustomer = customer.get();
        newCustomer.setId(currentCustomer.getId());
        return customerRepository.save(newCustomer);
    }

    @Override
    public Customer delete(Long customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        if (customer.isEmpty()) {
            return null;
        }
        customerRepository.delete(customer.get());
        return customer.get();
    }


}

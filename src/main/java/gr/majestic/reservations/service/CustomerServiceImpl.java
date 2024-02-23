package gr.majestic.reservations.service;

import gr.majestic.reservations.configuration.HotelMapper;
import gr.majestic.reservations.dto.CustomerDto;
import gr.majestic.reservations.model.Customer;
import gr.majestic.reservations.repository.CustomerRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final HotelMapper hotelMapper;

    @Override
    @Valid
    public Customer create(  Customer customer) throws  Exception{
        if (customer==null || customer.getName()==null || customer.getName().equals("") )
            throw new Exception();

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


    @Override
    public List<CustomerDto> readCustomerDto(Integer pageCount, Integer pageSize, String  name, String email, String year) {
        if (pageCount==null) pageCount=0;
        if (pageSize==null) pageSize=0;
        if(pageCount<0) pageCount = 1;
        if(pageSize<1 || pageSize>50) pageSize = 20;

        Pageable pageable = PageRequest.of(pageCount, pageSize);


return customerRepository.findCustomersByNameEmailYear(name,email,year)

   //     return customerRepository.findAll(pageable)
                .stream()
                .map(customer -> hotelMapper.customerMappingCustomerDto(customer))
                .collect(Collectors.toList());
    }
}

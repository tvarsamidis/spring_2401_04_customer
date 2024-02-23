package gr.majestic.reservations.controller;

import gr.majestic.reservations.configuration.HotelMapper;
import gr.majestic.reservations.dto.CustomerDto;
import gr.majestic.reservations.model.Customer;
import gr.majestic.reservations.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@AllArgsConstructor
public class CustomerController {
    
    private final CustomerService customerService;
    // CRUD
    // Create Read Update Delete

    private final HotelMapper mapper;

    @PostMapping("")
    @Validated
    public Customer createCustomer(@Validated @RequestBody Customer customer) {
        // save data
        return customerService.create(customer);
    }

    @GetMapping()
    public List<CustomerDto> readCustomer(@RequestParam(name="pageCount", required = false ) Integer pageCount,
                                          @RequestParam(name="pageSize", required = false )  Integer pageSize,
                                          @RequestParam(name="name", required = false) String name,
                                          @RequestParam(name="email", required = false)  String email,
                                          @RequestParam(name="year", required = false)  String year)  {
        return customerService.readCustomerDto(pageCount, pageSize, name, email, year);
    }

    @GetMapping("/js/{customerId}")
    public CustomerDto getCustomer(@PathVariable long customerId, @RequestHeader(name="Custom-Header", required = false) String customHeader) {
        return mapper.customerMappingCustomerDto(customerService.read(customerId));
    }


    @GetMapping(value="/xml/{customerId}", produces = MediaType.APPLICATION_XML_VALUE)
    public CustomerDto getCustomerAsXml(@PathVariable long customerId) {
        return mapper.customerMappingCustomerDto(customerService.read(customerId));
    }

    // Customer updateCustomer(int customerId, Customer newCustomerValues);
    @PutMapping("/{customerId}")
    public Customer updateCustomer(@PathVariable long customerId, @RequestBody Customer newCustomer) {
        return customerService.update(customerId, newCustomer);
    }

    //    boolean deleteCustomer(int customerId);
    @DeleteMapping("/{customerId}")
    public Customer deleteCustomer(@PathVariable long customerId) {
        return customerService.delete(customerId);
    }


}

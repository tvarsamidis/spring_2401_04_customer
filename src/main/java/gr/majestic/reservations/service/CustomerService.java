package gr.majestic.reservations.service;

import gr.majestic.reservations.dto.CustomerDto;
import gr.majestic.reservations.model.Customer;

import java.util.List;

public interface CustomerService extends GeneralService<Customer, Long>{

   List<CustomerDto> readCustomerDto(Integer pageCount, Integer pageSize, String  name, String email, String year);
}

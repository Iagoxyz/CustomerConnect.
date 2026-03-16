package tech.backend.customerconnect.service;

import org.springframework.stereotype.Service;
import tech.backend.customerconnect.controller.dto.CreateCustomerDto;
import tech.backend.customerconnect.entity.CustomerEntity;
import tech.backend.customerconnect.repository.CustomerRepository;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    public CustomerEntity createCustomer(CreateCustomerDto dto) {

        var newCustomer = new CustomerEntity();
        newCustomer.setFullName(dto.fullName());
        newCustomer.setCpf(dto.cpf());
        newCustomer.setEmail(dto.email());
        newCustomer.setPhoneNumber(dto.phoneNumber());

        return customerRepository.save(newCustomer);
    }
}

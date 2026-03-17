package tech.backend.customerconnect.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;



import org.springframework.util.StringUtils;
import tech.backend.customerconnect.controller.dto.CreateCustomerDto;
import tech.backend.customerconnect.controller.dto.UpdateCustomerDto;
import tech.backend.customerconnect.entity.CustomerEntity;
import tech.backend.customerconnect.repository.CustomerRepository;

import java.util.Optional;


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

    public Page<CustomerEntity> findAll(Integer page, Integer pageSize, String orderBy, String cpf, String email) {

        var direction = Sort.Direction.DESC;
        if ("asc".equalsIgnoreCase(orderBy)) {
            direction = Sort.Direction.ASC;
        }
        var pageRequest = PageRequest.of(page, pageSize, direction, "createdAt");

        if (StringUtils.hasText(cpf) && StringUtils.hasText(email)) {
           return customerRepository.findByCpfAndEmail(cpf, email, pageRequest);
        }

        if (StringUtils.hasText(cpf)) {
            return customerRepository.findByCpf(cpf, pageRequest);
        }

        if (StringUtils.hasText(email)) {
            return customerRepository.findByEmail(email, pageRequest);
        }

        return customerRepository.findAll(pageRequest);
    }

    public Optional<CustomerEntity> findById(Long id) {
        return customerRepository.findById(id);
    }

    public Optional<CustomerEntity> update(Long id, UpdateCustomerDto dto) {

        var customer = customerRepository.findById(id);

        if (customer.isPresent()) {
            if (StringUtils.hasText(dto.fullName())) {
                customer.get().setFullName(dto.fullName());
            }

            if (StringUtils.hasText(dto.email())) {
                customer.get().setEmail(dto.email());
            }

            if (StringUtils.hasText(dto.phoneNumber())) {
                customer.get().setPhoneNumber(dto.phoneNumber());
            }

            customerRepository.save(customer.get());
        }

        return customer;
    }

    public boolean deleteById(Long id) {

        var exists = customerRepository.existsById(id);

        if (exists) {
            customerRepository.deleteById(id);
        }

        return exists;
    }
}

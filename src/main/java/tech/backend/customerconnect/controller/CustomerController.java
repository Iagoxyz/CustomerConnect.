package tech.backend.customerconnect.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.backend.customerconnect.controller.dto.CreateCustomerDto;
import tech.backend.customerconnect.entity.CustomerEntity;
import tech.backend.customerconnect.service.CustomerService;

import java.net.URI;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<CustomerEntity> createCustomer(@RequestBody CreateCustomerDto dto) {

        var customer = customerService.createCustomer(dto);
        return ResponseEntity.created(URI.create("/customer" + customer.getCustomerId())).build();
    }

    @GetMapping
    public ResponseEntity<CustomerEntity> findAll() {
        var user = customerService.findAll();
        return null;
    }
}

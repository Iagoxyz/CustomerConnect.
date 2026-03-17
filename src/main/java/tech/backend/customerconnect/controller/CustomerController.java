package tech.backend.customerconnect.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.backend.customerconnect.controller.dto.ApiResponse;
import tech.backend.customerconnect.controller.dto.CreateCustomerDto;
import tech.backend.customerconnect.entity.CustomerEntity;
import tech.backend.customerconnect.service.CustomerService;

import java.net.URI;
import java.util.List;

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
    public ResponseEntity<ApiResponse<CustomerEntity>> findAll(@RequestParam(name = "page", defaultValue = "0") Integer page,
                                                               @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                                               @RequestParam(name = "orderBy", defaultValue = "desc") String orderBy,
                                                               @RequestParam(name = "cpf", required = false) String cpf,
                                                               @RequestParam(name = "email", required = false) String email) {
        var PageRequest = customerService.findAll(page, pageSize, orderBy, cpf, email);
        return ResponseEntity.ok(customer);
    }
}

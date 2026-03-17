package tech.backend.customerconnect.controller.dto;

import tech.backend.customerconnect.entity.CustomerEntity;

public record CreateCustomerDto(String fullName,
                                String cpf,
                                String email,
                                String phoneNumber) {


}

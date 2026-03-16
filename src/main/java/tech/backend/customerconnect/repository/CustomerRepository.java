package tech.backend.customerconnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.backend.customerconnect.entity.CustomerEntity;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
}

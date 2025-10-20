package labrini.ouiam.customerservice.repository;

import labrini.ouiam.customerservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

// This will create REST endpoints for Customer entity
@RepositoryRestResource
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}

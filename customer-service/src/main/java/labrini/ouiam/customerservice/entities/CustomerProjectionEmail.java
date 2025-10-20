package labrini.ouiam.customerservice.entities;

import org.springframework.data.rest.core.config.Projection;

// Projection interface to expose only name and email of Customer
@Projection(name = "email", types = Customer.class)
public interface CustomerProjectionEmail {
    String getEmail();
}

package labrini.ouiam.billingservice;

import labrini.ouiam.billingservice.entities.Bill;
import labrini.ouiam.billingservice.entities.ProductItem;
import labrini.ouiam.billingservice.feign.CustomerRestClient;
import labrini.ouiam.billingservice.feign.ProductRestClient;
import labrini.ouiam.billingservice.model.Customer;
import labrini.ouiam.billingservice.model.Product;
import labrini.ouiam.billingservice.repository.BillRepository;
import labrini.ouiam.billingservice.repository.ProductItemRepository;
import java.util.Collection;
import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(BillingServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(BillRepository billRepository,
                                        ProductItemRepository productItemRepository,
                                        CustomerRestClient customerRestClient,
                                        ProductRestClient productRestClient) {
        return args -> {
            Collection<Customer> customers = customerRestClient.getAllCustomer().getContent();
            Collection<Product> products = productRestClient.getAllProduct().getContent();

            customers.forEach(customer -> {

                Bill bill = Bill.builder()
                        .billingDate(new Date())
                        .customerId(customer.getId())
                        .build();
                billRepository.save(bill);

                products.forEach(product -> {

                    ProductItem productItem=ProductItem.builder()
                            .bill(bill)
                            .productId(product.getId())
                            .unitPrice(product.getPrice())
                            .quantity(1 + (int)(Math.random() * 10))
                            .build();
                    productItemRepository.save(productItem);
                });
            });
        };
    }
}

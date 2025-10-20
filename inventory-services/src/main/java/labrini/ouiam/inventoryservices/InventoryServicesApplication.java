package labrini.ouiam.inventoryservices;

import labrini.ouiam.inventoryservices.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class InventoryServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServicesApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository) {
        return args -> {
            productRepository.save(labrini.ouiam.inventoryservices.entities.Product.builder()
                    .id(UUID.randomUUID().toString())
                    .name("Computer")
                    .price(6500)
                    .quantity(5)
                    .build()
            );

            productRepository.save(labrini.ouiam.inventoryservices.entities.Product.builder()
                    .id(UUID.randomUUID().toString())
                    .name("Printer")
                    .price(1200)
                    .quantity(8)
                    .build()
            );

            productRepository.save(labrini.ouiam.inventoryservices.entities.Product.builder()
                    .id(UUID.randomUUID().toString())
                    .name("Smartphone")
                    .price(3000)
                    .quantity(15)
                    .build()
            );

            productRepository.findAll().forEach(product -> {
                System.out.println("=================================");
//                System.out.println(product.getId());
//                System.out.println(product.getName());
//                System.out.println(product.getPrice());
//                System.out.println(product.getQuantity());
                System.out.println(product.toString());
                System.out.println("=================================");
            });
        };
    }

}

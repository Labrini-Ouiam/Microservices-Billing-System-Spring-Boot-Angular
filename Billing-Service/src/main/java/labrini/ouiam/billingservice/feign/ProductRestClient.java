package labrini.ouiam.billingservice.feign;

import labrini.ouiam.billingservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "inventory-services")
public interface ProductRestClient {
    @GetMapping("/products/{id}")
    Product getProductById(@PathVariable String id);

    @GetMapping("/products")
    PagedModel<Product> getAllProduct();
}

package labrini.ouiam.billingservice.web;

import labrini.ouiam.billingservice.entities.Bill;
import labrini.ouiam.billingservice.feign.CustomerRestClient;
import labrini.ouiam.billingservice.feign.ProductRestClient;
import labrini.ouiam.billingservice.repository.BillRepository;
import labrini.ouiam.billingservice.repository.ProductItemRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillRestController {
    private BillRepository billRepository;
    private ProductItemRepository productItemRepository;
    private CustomerRestClient customerRestClient;
    private ProductRestClient productRestClient;

    public BillRestController(BillRepository billRepository, ProductItemRepository productItemRepository, CustomerRestClient customerRestClient, ProductRestClient productRestClient) {
        this.billRepository = billRepository;
        this.productItemRepository = productItemRepository;
        this.customerRestClient = customerRestClient;
        this.productRestClient = productRestClient;
    }

    @GetMapping(path = "/bills/{id}")
    public Bill getBill(@PathVariable Long id){
        Bill bill= billRepository.findById(id).get();
        bill.setCustomer(customerRestClient.getCustomerById(bill.getCustomerId()));
        bill.getProductItems().forEach(pi->{
            pi.setProduct(productRestClient.getProductById(pi.getProductId()));
        });
        return bill;
    }
}

package labrini.ouiam.billingservice.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import labrini.ouiam.billingservice.model.Product;
import lombok.*;

@Entity
@NoArgsConstructor @AllArgsConstructor
@Getter
@Setter
@ToString @Builder
public class ProductItem {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productId;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Bill bill;
    private int quantity;
    private double unitPrice;
    //for temporary use
    @Transient
    private Product product;
}

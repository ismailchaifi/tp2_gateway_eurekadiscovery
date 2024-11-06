package ma.enset.billingservice.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Product {
    private Long id;
    private String name;
    private double price;
    private int quantity;
}

package ma.enset.inventoryservice;

import ma.enset.inventoryservice.entities.Product;
import ma.enset.inventoryservice.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository,
                                        RepositoryRestConfiguration restConfiguration) {
        restConfiguration.exposeIdsFor(Product.class);
        return args -> {
            productRepository.save(new Product(null, "product1", 900, 5));
            productRepository.save(new Product(null, "product2", 840, 11));
            productRepository.save(new Product(null, "product3", 370, 6));
            productRepository.findAll().forEach(product -> System.out.println(product.getName()));
        };
    }

}

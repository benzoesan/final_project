package pl.coderslab.applicationtomanagetheclaimsprecess.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.applicationtomanagetheclaimsprecess.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {
}

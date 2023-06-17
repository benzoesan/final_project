package pl.coderslab.applicationtomanagetheclaimsprecess.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.applicationtomanagetheclaimsprecess.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
}

package pl.coderslab.applicationtomanagetheclaimsprecess.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.coderslab.applicationtomanagetheclaimsprecess.entity.Complaint;
import pl.coderslab.applicationtomanagetheclaimsprecess.entity.Customer;

import java.util.List;


@Repository
public interface ComplaintRepository extends JpaRepository<Complaint, Long> {

    @Modifying
    @Query("UPDATE Complaint c SET c.state = :newState WHERE c.id = :complaintId")
    void aktualizujStatusReklamacji(@Param("complaintId") Long complaintId, @Param("newState") String newState);

    @Query("SELECT c FROM Complaint c WHERE c.customer.lastName = :lastName")
    List<Complaint> findByCustomerLastName(@Param("lastName") String lastName);
    @Query("select c from Complaint c where c.customer = :customer")
    List<Complaint> findByCustomer(@Param("customer") Customer customer);

    List<Complaint> findByState(String state);

}

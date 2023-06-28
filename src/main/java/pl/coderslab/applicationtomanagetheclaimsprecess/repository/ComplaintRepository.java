package pl.coderslab.applicationtomanagetheclaimsprecess.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.coderslab.applicationtomanagetheclaimsprecess.entity.Complaint;


@Repository
public interface ComplaintRepository extends JpaRepository<Complaint, Long> {

    @Modifying
    @Query("UPDATE Complaint c SET c.state = :newState WHERE c.id = :complaintId")
    void aktualizujStatusReklamacji(@Param("complaintId") Long complaintId, @Param("newState") String newState);

}

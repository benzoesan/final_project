package pl.coderslab.applicationtomanagetheclaimsprecess.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.applicationtomanagetheclaimsprecess.entity.Role;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
   Role findByName(String name);
}

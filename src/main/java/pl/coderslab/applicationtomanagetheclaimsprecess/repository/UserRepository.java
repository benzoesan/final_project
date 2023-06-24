package pl.coderslab.applicationtomanagetheclaimsprecess.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.applicationtomanagetheclaimsprecess.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByLogin(String login);
    Optional<User> findByEmail(String email);
}

package pl.coderslab.applicationtomanagetheclaimsprecess.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.applicationtomanagetheclaimsprecess.dto.RegistrationDto;
import pl.coderslab.applicationtomanagetheclaimsprecess.repository.UserRepository;

@Service
@Transactional

public interface UserService {
    void saveUser(RegistrationDto registrationDto);

}

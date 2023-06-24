package pl.coderslab.applicationtomanagetheclaimsprecess.service;

import lombok.NoArgsConstructor;
import pl.coderslab.applicationtomanagetheclaimsprecess.dto.RegistrationDto;
import pl.coderslab.applicationtomanagetheclaimsprecess.entity.Role;
import pl.coderslab.applicationtomanagetheclaimsprecess.entity.User;
import pl.coderslab.applicationtomanagetheclaimsprecess.repository.RoleRepository;
import pl.coderslab.applicationtomanagetheclaimsprecess.repository.UserRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@NoArgsConstructor
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @Override
    public void saveUser(RegistrationDto registrationDto) {
    User user = new User();
    user.setLogin(registrationDto.getLogin());
    user.setEmail(registrationDto.getEmail());
    user.setPassword(registrationDto.getPassword());
    Role role = roleRepository.findByName("USER");
    user.setRoles(Arrays.asList(role));
    userRepository.save(user);
    }
}

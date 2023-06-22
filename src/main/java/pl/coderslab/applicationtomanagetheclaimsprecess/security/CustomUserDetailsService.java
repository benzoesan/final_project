//package pl.coderslab.applicationtomanagetheclaimsprecess.security;
//
//import lombok.Data;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//
//import java.awt.*;
//import java.util.Collection;
//import java.util.Collections;
//import java.util.logging.SimpleFormatter;
//import java.util.stream.Collectors;
//
//@Service
//@Transactional
//@Data
//public class CustomUserDetailsService implements UserDetailsService {
//
////private UserRepository userRepository;
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//

//       final User user = userRepository.findByUsername(username)
//                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
//
//
//        final Collection<? extends GrantedAuthority> authorities=
//               user.getRoles()
//                       .stream()
//                       .map(Role::getName)
//                       .map("ROLE_"::concat)
//                       .map(SimpleGrantedAuthority::new)
//                       .collect(Collectors.toList());


//        return org.springframework.security.core.userdetails.User.builder()
//                .username(user.getUsername())
//                .password(user.getPassword())
//                .authorities(Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")))
//                .build();

//        return new CustomUserDetails("admin2","{noop}admin2", Collections.emptyList());
//    }
//}

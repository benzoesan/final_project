package pl.coderslab.applicationtomanagetheclaimsprecess.security;

import org.springframework.context.annotation.Bean;
 import org.springframework.context.annotation.Configuration;
 import org.springframework.security.config.annotation.web.builders.HttpSecurity;
 import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
 import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
 import org.springframework.security.crypto.password.PasswordEncoder;
 import org.springframework.security.web.SecurityFilterChain;

 @Configuration
public class SecurityConfig {

     @Bean
     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
         return http.authorizeHttpRequests((requests)->requests
                         .shouldFilterAllDispatcherTypes(false)
                         .requestMatchers("/login").permitAll()
                         .requestMatchers("/css/**").permitAll()
                         .requestMatchers("/js/**").permitAll()
                         .anyRequest().authenticated())
                 .formLogin(form -> form
                 .loginPage("/login")
                         .defaultSuccessUrl("/complaint/home")
                         .loginProcessingUrl("/login")
                 .permitAll()
         )
                 .build();
     }


//     @Bean
//     public PasswordEncoder passwordEncoder() {
//         return new BCryptPasswordEncoder();
//     }
}
package pl.coderslab.applicationtomanagetheclaimsprecess.security;

import org.springframework.context.annotation.Bean;
 import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
 import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
 import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
 import org.springframework.security.crypto.password.PasswordEncoder;
 import org.springframework.security.web.SecurityFilterChain;

 @Configuration
public class SecurityConfig {

     @Bean
     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {



         return http
                 .csrf().disable()
                 .authorizeHttpRequests((requests)->requests
                         .shouldFilterAllDispatcherTypes(false)
                         .requestMatchers(HttpMethod.POST, "/complaint/{complaintId}/state").permitAll()
                         .requestMatchers("/login", "/mail/send").permitAll()
                         .requestMatchers("/css/**","/images/**" ).permitAll()
                         .requestMatchers("/js/**").permitAll()
                         .anyRequest().authenticated())
                 .formLogin(form -> {
                     try {
                         form
                         .loginPage("/login")
                                 .defaultSuccessUrl("/complaint/home")
                                 .loginProcessingUrl("/login")
                                 .and().logout().logoutUrl("/logout").logoutSuccessUrl("/login")
                         .permitAll();
                     } catch (Exception e) {
                         throw new RuntimeException(e);
                     }
                 }
         )
                 .build();
     }


//     @Bean
//     public PasswordEncoder passwordEncoder() {
//         return new BCryptPasswordEncoder();
//     }
}

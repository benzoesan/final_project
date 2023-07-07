package pl.coderslab.applicationtomanagetheclaimsprecess.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Data
@Setter
@Getter
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Pole imię nie może być puste")
    private String firstName;
    @NotEmpty(message = "Pole nazwisko nie może być puste")
    private String lastName;
    @Email(message = "Pole email nie może być puste")
    private String email;
    @NotEmpty(message = "Pole telefon nie może być puste")
    private String phone;

    @OneToMany(mappedBy = "customer")
    private List<Complaint> complaints;

    public String getFullName() {
        return firstName + " " + lastName;
    }
}
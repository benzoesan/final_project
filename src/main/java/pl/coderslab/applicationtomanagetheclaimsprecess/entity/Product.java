package pl.coderslab.applicationtomanagetheclaimsprecess.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Pole nazwa nie może być puste")
    private String name;
    @NotEmpty(message = "Pole inkeks nie może być puste")
    private String produceCode;
    private String description;
    private double price;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate purchaseDate;
    @NotEmpty(message = "Pole numer dokumentu sprzedaży nie może być puste")
    private String salesDocumentNumber;
    private String salesDocumentType;


}

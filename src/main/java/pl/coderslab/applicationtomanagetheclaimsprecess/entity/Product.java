package pl.coderslab.applicationtomanagetheclaimsprecess.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String produceCode;
    private String description;
    private double price;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate purchaseDate;
    private long salesDocumentNumber;
    private String salesDocumentType;


}

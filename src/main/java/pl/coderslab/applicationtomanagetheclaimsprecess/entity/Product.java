package pl.coderslab.applicationtomanagetheclaimsprecess.entity;

import jakarta.persistence.*;
import lombok.Data;

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
    private LocalDate purchaseDate;
    private long salesDocumentNumber;
    private String salesDocumentType;


}

package pl.coderslab.applicationtomanagetheclaimsprecess.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;


import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "complaints")
public class Complaint {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne
        private Customer customer;

        @ManyToOne
        private Product product;
        @DateTimeFormat(pattern = "dd-MM-yyyy")
        private LocalDateTime dateOfComplaint;
        @DateTimeFormat(pattern = "dd-MM-yyyy")
        private LocalDateTime dateOfDefect;
        private int daysToDetermination;
        public List<String> defectDescription;
        private String typeOfDamage;
        private String comments;
        private List<String> advertiserExpectations;
        public List<String> status;
}

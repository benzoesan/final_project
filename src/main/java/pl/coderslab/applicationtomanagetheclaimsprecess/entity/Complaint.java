package pl.coderslab.applicationtomanagetheclaimsprecess.entity;

import jakarta.persistence.*;
import lombok.Data;


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

        private LocalDateTime dateOfComplaint;
        private LocalDateTime dateOfDefect;
        private int daysToDetermination;
        public List<String> defectDescription;
        private String typeOfDamage;
        private String comments;
        private List<String> advertiserExpectations;
        public List<String> status;
}

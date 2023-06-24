package pl.coderslab.applicationtomanagetheclaimsprecess.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;
import java.util.List;


@Entity
@Setter
@Getter
@ToString
@Table(name = "complaints")
public class Complaint {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne
        private Customer customer;

        @ManyToOne
        private Product product;
        @DateTimeFormat(pattern = "dd.MM.yyyy")
        private LocalDate dateOfComplaint;
        @DateTimeFormat(pattern = "dd.MM.yyyy")
        private LocalDate dateOfDefect;
        private LocalDate dateOfDetermination;
        public String defectDescription;
        public List<String> typeOfDamage;
        private String comments;
        private List<String> advertiserExpectations;
        public List<String> state;
}

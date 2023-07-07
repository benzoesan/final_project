package pl.coderslab.applicationtomanagetheclaimsprecess.entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;
import pl.coderslab.applicationtomanagetheclaimsprecess.Model.ComplaintState;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
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
        @Valid
        private Customer customer;
        @ManyToOne
        @Valid
        private Product product;
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private LocalDate dateOfComplaint;
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private LocalDate dateOfDefect;
        private LocalDate dateOfDetermination;
        public String defectDescription;
        public String typeOfDamage;
        @NotEmpty(message = "Komentarz nie może być pusty")
        private String comments;
        private String advertiserExpectations;
        public String state;
        private String justification;
        public void aktualizujStatusReklamacji(String newState) {
                this.state = Collections.singletonList(newState).toString();
        }
}

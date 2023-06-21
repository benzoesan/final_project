package pl.coderslab.applicationtomanagetheclaimsprecess.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.applicationtomanagetheclaimsprecess.entity.Complaint;
import pl.coderslab.applicationtomanagetheclaimsprecess.repository.ComplaintRepository;

import java.time.LocalDate;

import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor
public class ComplaintService {
    private final ComplaintRepository complaintRepository;

    public List<Complaint> getAllComplaints() {
        return complaintRepository.findAll();
    }

    public void createComplaint(Complaint complaint) {
        complaint.setDateOfComplaint(LocalDate.now());
        complaintRepository.save(complaint);
    }

    public Complaint getComplaintById(Long id) {
        return complaintRepository.findById(id).get();
    }

    public void updateComplaint(Complaint complaint) {
        complaintRepository.save(complaint);
    }

    public void deleteComplaintById(Long id) {
        complaintRepository.deleteById(id);
    }


    // Klasa obsługująca logikę związaną z reklamacjami

    private static final int MAX_DAYS_TO_DETERMINATION = 14;

    public void calculateAndSetDeadline(Complaint complaint) {
        LocalDate dateOfComplaint = complaint.getDateOfComplaint();
        LocalDate deadline = dateOfComplaint.plusDays(MAX_DAYS_TO_DETERMINATION);
        complaint.setDaysToDetermination(deadline);
    }
}

//        public int calculateDaysToDetermination(Complaint complaint) {
//            LocalDate currentDate = LocalDate.now();
//            LocalDate deadline = complaint.getDateOfComplaint().plusDays(MAX_DAYS_TO_DETERMINATION);
//            long daysRemaining = ChronoUnit.DAYS.between(currentDate, deadline);
//            return (int) Math.max(daysRemaining, 0);
//        }
//        public void updateComplaintWithDaysToDetermination(Complaint complaint) {
//            int daysToDetermination = calculateDaysToDetermination(complaint);
//            complaint.setDaysToDetermination(daysToDetermination);
//            // Zapisz zmodyfikowany obiekt Complaint do bazy danych lub innego źródła danych
//        }

//        public boolean isDeadlineExpired(Complaint complaint) {
//            LocalDate currentDate = LocalDate.now();
//            LocalDate deadline = complaint.getDateOfComplaint().plusDays(MAX_DAYS_TO_DETERMINATION);
//            return currentDate.isAfter(deadline);
//        }
//    }



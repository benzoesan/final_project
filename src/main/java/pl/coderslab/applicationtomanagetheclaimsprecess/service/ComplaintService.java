package pl.coderslab.applicationtomanagetheclaimsprecess.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.applicationtomanagetheclaimsprecess.entity.Complaint;
import pl.coderslab.applicationtomanagetheclaimsprecess.entity.Customer;
import pl.coderslab.applicationtomanagetheclaimsprecess.repository.ComplaintRepository;

import java.time.LocalDate;

import java.util.List;
import java.util.NoSuchElementException;


@Service
@Transactional
@Data
public class ComplaintService {
    private final ComplaintRepository complaintRepository;
    private final EmailSenderService emailSenderService;

    @Autowired
    public ComplaintService(ComplaintRepository complaintRepository, EmailSenderService emailSenderService) {
        this.complaintRepository = complaintRepository;
        this.emailSenderService = emailSenderService;
    }

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
        // Pobiera poprzednią reklamację z bazy danych
        Complaint previousComplaint = complaintRepository.findById(complaint.getId()).orElse(null);
        if (previousComplaint != null) {
            String previousStatus = previousComplaint.getState();
            String currentStatus = complaint.getState();

            if (!previousStatus.equals(currentStatus)) {
                // Wywołuje metodę wysyłającą e-mail przy zmianie statusu reklamacji
                String customerEmail = complaint.getCustomer().getEmail();
                emailSenderService.sendEmailOnStatusChange(complaint, customerEmail);
            }
        }
        complaintRepository.save(complaint);
    }

    public void deleteComplaintById(Long id) {
        complaintRepository.deleteById(id);
    }



//    data przeterminowania
    private static final int MAX_DAYS_TO_DETERMINATION = 14;
    public void calculateExpirationDate(Complaint complaint) {
        LocalDate expirationDate = complaint.getDateOfComplaint().plusDays(MAX_DAYS_TO_DETERMINATION);
        complaint.setDateOfDetermination(expirationDate);
    }

// wyszukiwanie
    public List<Complaint> findByLastName(String lastName) {
        return complaintRepository.findByCustomerLastName(lastName);
    }

    public List<Complaint> findByState(String state) {
        return complaintRepository.findByState(state);
    }

}




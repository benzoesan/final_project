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
        complaintRepository.save(complaint);
    }

    public void deleteComplaintById(Long id) {
        complaintRepository.deleteById(id);
    }

    private static final int MAX_DAYS_TO_DETERMINATION = 14;

    //
    public void calculateExpirationDate(Complaint complaint) {
        LocalDate expirationDate = complaint.getDateOfComplaint().plusDays(14);
        complaint.setDateOfDetermination(expirationDate);
    }

//    // Metoda do zmiany statusu reklamacji
//    public void changeState(Complaint complaint, List<String> newState) {
//        complaint.setState(newState);
//
//        // Tutaj wywołujemy metodę do wysyłania wiadomości e-mail z nowym statusem reklamacji
//        String customerEmail = complaint.getCustomer().getEmail(); // Pobranie adresu e-mail klienta
//        emailSenderService.sendEmailOnStatusChange(complaint, customerEmail); // Wywołanie metody wysyłającej wiadomość e-mail
//    }


    public void aktualizujStatusReklamacji(Long complaintId, String newState) {
        Complaint complaint = complaintRepository.findById(complaintId)
                .orElseThrow(() -> new NoSuchElementException("Reklamacja o podanym ID nie istnieje"));

        complaintRepository.aktualizujStatusReklamacji(complaintId, newState);
       // String updatedState = complaint.getState().toString();
        if (!complaint.getState().equals(newState)) {
            wyslijEmailKlientowi(complaint, newState);
        }

    }

    private void wyslijEmailKlientowi(Complaint complaint, String newState) {

        String adresEmail = complaint.getCustomer().getEmail();
        String [] cc= null;
        String temat = "Status reklamacji został zmieniony";
        String tresc = "Twój numer reklamacji: " + complaint.getId() +
                "\nNowy status reklamacji: " + newState;

        emailSenderService.sendEmail(null,adresEmail, null, temat, tresc);
    }

    public List<Complaint> findByLastName(String lastName) {
        return complaintRepository.findByCustomerLastName(lastName);
    }
//
//    public List<Complaint> findByCustomerLastName(String lastName) {
//        return complaintRepository.findByCustomerLastName(lastName);
//    }

    public List<Complaint> findByCustomer(Customer customer) {
        return complaintRepository.findByCustomer(customer);
    }

    public List<Complaint> findByState(String state) {
        return complaintRepository.findByState(state);
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



//package pl.coderslab.applicationtomanagetheclaimsprecess.service;
//
//import lombok.Data;
//import org.springframework.stereotype.Service;
//import pl.coderslab.applicationtomanagetheclaimsprecess.entity.Complaint;
//import pl.coderslab.applicationtomanagetheclaimsprecess.entity.Customer;
//
//@Service
//@Data
//public class EmailComplaintStatusChangeListener implements ComplaintStatusChangeListener{
//    Customer customer = new Customer();
//    private EmailSenderService emailSenderService;
//
//    public EmailComplaintStatusChangeListener(EmailSenderService emailSenderService) {
//        this.emailSenderService = emailSenderService;
//    }
//    @Override
//    public void onComplaintStatusChanged(Complaint complaint, String oldStatus, String newStatus) {
//        String to = customer.getEmail(); // Adres e-mail klienta
//        String subject = "Zmiana statusu reklamacji";
//        String body = "Status reklamacji zmieniony z: " + oldStatus + " na: " + newStatus;
//
//        // Wywołanie metody wysyłającej e-mail
//        emailSenderService.sendEmail(null,to,null, subject,body);
//    }
//}

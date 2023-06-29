package pl.coderslab.applicationtomanagetheclaimsprecess.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pl.coderslab.applicationtomanagetheclaimsprecess.entity.Complaint;

@Service
public interface EmailSenderService {

   String sendEmail(String to, String subject, String body);

   void sendEmailOnStatusChange(Complaint complaint, String to);
}

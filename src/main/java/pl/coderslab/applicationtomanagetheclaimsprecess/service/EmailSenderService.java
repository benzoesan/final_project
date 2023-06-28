package pl.coderslab.applicationtomanagetheclaimsprecess.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pl.coderslab.applicationtomanagetheclaimsprecess.entity.Complaint;

@Service
public interface EmailSenderService {

   String sendEmail(MultipartFile[] file, String to, String[] cc, String subject, String body);

   void sendEmailOnStatusChange(Complaint complaint, String to);
}

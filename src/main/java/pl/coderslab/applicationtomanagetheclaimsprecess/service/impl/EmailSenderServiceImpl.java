package pl.coderslab.applicationtomanagetheclaimsprecess.service.impl;

import jakarta.mail.internet.MimeMessage;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pl.coderslab.applicationtomanagetheclaimsprecess.entity.Complaint;
import pl.coderslab.applicationtomanagetheclaimsprecess.service.EmailSenderService;

@Service
@Data
@NoArgsConstructor
public class EmailSenderServiceImpl implements EmailSenderService {


    //@Value("${spring.mail.username}")
    private String fromEmail = "dawidszewczyk12@gmail.com";
    @Autowired
    private JavaMailSender mailSender;

    public EmailSenderServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }


    @Override
    public String sendEmail(String to, String subject, String body) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(fromEmail);
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setText(body);

            mailSender.send(mimeMessage);
            return "send mail";

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    

    @Override
    public void sendEmailOnStatusChange(Complaint complaint, String to) {
        String subject = "Zmiana statusu reklamacji";
        String body = "Szanowny Kliencie,\n\nInformujemy o zmianie statusu reklamacji o numerze " +
                complaint.getId() + ". Nowy status reklamacji to: " + complaint.getState() + ".\n\n" +
                "Pozdrawiamy,\nZespół Obsługi Klienta";

        sendEmail(to, subject, body);
    }
}

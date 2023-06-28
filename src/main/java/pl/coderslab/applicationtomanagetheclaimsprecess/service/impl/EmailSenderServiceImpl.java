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
    public String sendEmail(MultipartFile[] file, String to, String[] cc, String subject, String body) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(fromEmail);
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setCc(cc);
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setText(body);

            for(int i =0; i < file.length;i++){
                mimeMessageHelper.addAttachment(
                        file[i].getOriginalFilename(),
                        new ByteArrayResource(file[i].getBytes())
                );
            }

            mailSender.send(mimeMessage);
            return "send mail";

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void sendEmailOnStatusChange(Complaint complaint, String to) {

    }

//    @Override
//    public void sendEmailOnStatusChange(Complaint complaint, String to) {
//        String subject = "Zmiana statusu reklamacji";
//        String body = "Status reklamacji o ID: " + complaint.getId() + " został zmieniony na: " + complaint.getState();
//
//        sendEmail(null, to, null, subject, body);
//    }
}

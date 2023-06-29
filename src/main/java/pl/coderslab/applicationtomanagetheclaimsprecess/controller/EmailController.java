package pl.coderslab.applicationtomanagetheclaimsprecess.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.coderslab.applicationtomanagetheclaimsprecess.resource.EmailMessage;
import pl.coderslab.applicationtomanagetheclaimsprecess.service.EmailSenderService;

@RestController
@RequestMapping("/mail")
public class EmailController {
    private final EmailSenderService emailSenderService;

    public EmailController(EmailSenderService emailSenderService) {
        this.emailSenderService = emailSenderService;
    }

    @PostMapping("/send")
    public String sendEmail(
            //@RequestParam (value = "file", required = false) MultipartFile[] file,
                            String to, String subject, String body){
        return emailSenderService.sendEmail(to, subject,body);
    }
}

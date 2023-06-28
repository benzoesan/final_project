package pl.coderslab.applicationtomanagetheclaimsprecess.resource;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class EmailMessage {
    private String to;
    private String subject;
    private String message;
}

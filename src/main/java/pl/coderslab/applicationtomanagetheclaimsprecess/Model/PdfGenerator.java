//package pl.coderslab.applicationtomanagetheclaimsprecess.Model;
//
//import com.itextpdf.text.Document;
//import com.itextpdf.text.DocumentException;
//import com.itextpdf.text.Paragraph;
//import com.itextpdf.text.pdf.PdfWriter;
//import pl.coderslab.applicationtomanagetheclaimsprecess.entity.Complaint;
//
//import java.io.ByteArrayOutputStream;
//
//public class PdfGenerator {
//
//    public static ByteArrayOutputStream generatePdfFromComplaint(Complaint complaint) throws DocumentException {
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        Document document = new Document();
//
//        // Tworzenie zawartości dokumentu
//        StringBuilder content = new StringBuilder();
//        content.append("DANE REKLAMUJĄCEGO:\n");
//        content.append("Imię: ").append(complaint.getCustomer().getFirstName()).append("\n");
//        content.append("Nazwisko: ").append(complaint.getCustomer().getLastName()).append("\n");
//        content.append("E-mail: ").append(complaint.getCustomer().getEmail()).append("\n");
//        content.append("Numer telefonu: ").append(complaint.getCustomer().getPhone()).append("\n");
//
//        content.append("\nINFORMACJE O PRODUKCIE:\n");
//        content.append("Nazwa produktu: ").append(complaint.getProduct().getName()).append("\n");
//        content.append("Opis produktu: ").append(complaint.getProduct().getDescription()).append("\n");
//        content.append("Indeks: ").append(complaint.getProduct().getProduceCode()).append("\n");
//        content.append("Cena: ").append(complaint.getProduct().getPrice()).append("\n");
//        content.append("Data zakupu: ").append(complaint.getProduct().getPurchaseDate()).append("\n");
//        content.append("Numer dokumentu sprzedaży: ").append(complaint.getProduct().getSalesDocumentNumber()).append("\n");
//        content.append("Typ dokumentu sprzedaży: ").append(complaint.getProduct().getSalesDocumentType()).append("\n");
//
//        content.append("\nPRZYCZYNY REKLAMACJI:\n");
//        content.append("Data powstania wady: ").append(complaint.getDateOfDefect()).append("\n");
//        content.append("Rodzaj uszkodzenia: ").append(complaint.getTypeOfDamage()).append("\n");
//        content.append("Opis szczegółowy wady: ").append(complaint.getDefectDescription()).append("\n");
//
//        content.append("\nOczekiwania klienta:\n");
//        content.append("Zwrot środków: ").append(complaint.getAdvertiserExpectations().contains("Zwrot środków") ? "Tak" : "Nie").append("\n");
//        content.append("Wymiana: ").append(complaint.getAdvertiserExpectations().contains("Wymiana") ? "Tak" : "Nie").append("\n");
//        content.append("Naprawa: ").append(complaint.getAdvertiserExpectations().contains("Naprawa") ? "Tak" : "Nie").append("\n");
//
//        content.append("\nDodatkowe uwagi: ").append(complaint.getComments()).append("\n");
//        content.append("Data złożenia reklamacji: ").append(complaint.getDateOfComplaint()).append("\n");
//        content.append("Status reklamacji: ").append(complaint.getState()).append("\n");
//
//
//        try {
//            PdfWriter.getInstance(document, baos);
//            document.open();
//
//            // Dodawanie zawartości do dokumentu
//            document.add(new Paragraph(content.toString()));
//
//            document.close();
//        } catch (DocumentException e) {
//            // Obsługa wyjątku DocumentException
//            e.printStackTrace();
//        }
//
//        return baos;
//    }
//}

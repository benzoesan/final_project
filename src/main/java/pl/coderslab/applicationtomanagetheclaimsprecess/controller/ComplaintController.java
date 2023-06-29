package pl.coderslab.applicationtomanagetheclaimsprecess.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.applicationtomanagetheclaimsprecess.Model.ComplaintState;
import pl.coderslab.applicationtomanagetheclaimsprecess.entity.Complaint;
import pl.coderslab.applicationtomanagetheclaimsprecess.entity.Customer;
import pl.coderslab.applicationtomanagetheclaimsprecess.service.ComplaintService;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Controller
public class ComplaintController {
    private final ComplaintService complaintService;


    @Autowired
    public ComplaintController(ComplaintService complaintService) {
        this.complaintService = complaintService;

    }
    private void calculateExpirationDate(Complaint complaint) {
        LocalDate expirationDate = complaint.getDateOfComplaint().plusDays(14);
        complaint.setDateOfDetermination(expirationDate);
    }

    @PostMapping(path = "/complaint")
    void save (@RequestParam LocalDate dateOfComplaint,
               @RequestParam LocalDate dateOfDefect,
               @RequestParam LocalDate dateOfDtermination,
               @RequestParam String defectDescription,
               @RequestParam List<String> typeOfDamage,
               @RequestParam String comments,
               @RequestParam List<String> advertiserExpectations,
               @RequestParam String state){

        final Complaint complaint = new Complaint();
        complaint.setDateOfComplaint(dateOfComplaint);
        complaint.setDateOfDefect(dateOfDefect);
        complaint.setDateOfDetermination(dateOfDtermination);
        complaint.setDefectDescription(defectDescription);
        complaint.setTypeOfDamage(typeOfDamage);
        complaint.setComments(comments);
        complaint.setAdvertiserExpectations(advertiserExpectations);
        complaint.setState(state);

        Customer customer = new Customer();
        customer.setFirstName(customer.getLastName());

        complaintService.createComplaint(complaint);
    }
    @GetMapping(path = "/complaint/home", produces = "text/plain;charset=utf-8")
    String showComplains(Model model) {
        final List<Complaint> complaints = complaintService.getAllComplaints();
        model.addAttribute("complaints", complaints);
        return "complaint/home";
    }

    @GetMapping(path = "/complaint/{id}", produces = "text/plain;charset=utf-8")
    String findById(@PathVariable Long id){
        Complaint complaint = complaintService.getComplaintById(id);
        return complaint!=null ? complaint.toString() : "Nie znaleziono reklamacji";
    }

    @PutMapping(path = "/complaint/{id}")
    void update(@PathVariable Long id,
               // @RequestParam LocalDateTime dateOfComplaint,
                @RequestParam LocalDate dateOfDefect,
                @RequestParam LocalDate dateOfDtermination,
                @RequestParam String defectDescription,
                @RequestParam List<String> typeOfDamage,
                @RequestParam String comments,
                @RequestParam List<String> advertiserExpectations,
                @RequestParam String state){

        final Complaint complaint = complaintService.getComplaintById(id);
        if (Objects.nonNull(complaint)) {
           // complaint.setDateOfComplaint(dateOfComplaint);
            complaint.setDateOfDefect(dateOfDefect);
            complaint.setDateOfDetermination(dateOfDtermination);
            complaint.setDefectDescription(defectDescription);
            complaint.setTypeOfDamage(typeOfDamage);
            complaint.setComments(comments);
            complaint.setAdvertiserExpectations(advertiserExpectations);
            complaint.setState(state);

            complaintService.updateComplaint(complaint);
        }
    }
    @DeleteMapping(path = "/complaint/{id}")
    void deleteById(@PathVariable Long id) {
        complaintService.deleteComplaintById(id);
    }

    @PostMapping("/complaint/{complaintId}/state")
    public ResponseEntity<String> aktualizujStatusReklamacji(@PathVariable Long complaintId, @RequestBody String newState) {
        complaintService.aktualizujStatusReklamacji(complaintId, newState);
        return ResponseEntity.ok("Status reklamacji został zaktualizowany.");
    }

//    @PostMapping("/complaint/{complaintId}/state")
//    public ResponseEntity<String> aktualizujStatusReklamacji(@PathVariable("complaintId") Long complaintId) {
//        Complaint complaint = complaintService.getComplaintById(complaintId);
//        String newState = complaint.getState().toString();
//
//        complaintService.aktualizujStatusReklamacji(complaintId, newState);
//
//
//        wyslijEmailKlientowi(complaint, newState);
//
//        return ResponseEntity.ok("Status reklamacji został zaktualizowany. Wiadomość e-mail została wysłana.");
//    }
//
//    private void wyslijEmailKlientowi(Complaint complaint, String newState) {
//    }

}


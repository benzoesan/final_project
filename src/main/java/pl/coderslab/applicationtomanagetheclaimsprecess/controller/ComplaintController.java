package pl.coderslab.applicationtomanagetheclaimsprecess.controller;

import org.springframework.web.bind.annotation.*;
import pl.coderslab.applicationtomanagetheclaimsprecess.entity.Complaint;
import pl.coderslab.applicationtomanagetheclaimsprecess.entity.Customer;
import pl.coderslab.applicationtomanagetheclaimsprecess.service.ComplaintService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@RestController
public class ComplaintController {
    private final ComplaintService complaintService;


    public ComplaintController(ComplaintService complaintService) {
        this.complaintService = complaintService;
    }

    @PostMapping(path = "/complaint")
    void save (@RequestParam LocalDateTime dateOfComplaint,
               @RequestParam LocalDateTime dateOfDefect,
               @RequestParam int daysToDetermination,
               @RequestParam List<String> defectDescription,
               @RequestParam String typeOfDamage,
               @RequestParam String comments,
               @RequestParam List<String> advertiserExpectations,
               @RequestParam List<String> status){

        final Complaint complaint = new Complaint();
        complaint.setDateOfComplaint(dateOfComplaint);
        complaint.setDateOfDefect(dateOfDefect);
        complaint.setDaysToDetermination(daysToDetermination);
        complaint.setDefectDescription(defectDescription);
        complaint.setTypeOfDamage(typeOfDamage);
        complaint.setComments(comments);
        complaint.setAdvertiserExpectations(advertiserExpectations);
        complaint.setStatus(status);

        Customer customer = new Customer();
        customer.setFirstName(customer.getLastName());

        complaintService.createComplaint(complaint);
    }

    @GetMapping(path = "/complaint/{id}", produces = "text/plain;charset=utf-8")
    String findById(@PathVariable Long id){
        Complaint complaint = complaintService.getComplaintById(id);
        return complaint!=null ? complaint.toString() : "Nie znaleziono reklamacji";
    }

    @PutMapping(path = "/complaint/{id}")
    void update(@PathVariable Long id,
               // @RequestParam LocalDateTime dateOfComplaint,
                @RequestParam LocalDateTime dateOfDefect,
                @RequestParam int daysToDetermination,
                @RequestParam List<String> defectDescription,
                @RequestParam String typeOfDamage,
                @RequestParam String comments,
                @RequestParam List<String> advertiserExpectations,
                @RequestParam List<String> status){

        final Complaint complaint = complaintService.getComplaintById(id);
        if (Objects.nonNull(complaint)) {
           // complaint.setDateOfComplaint(dateOfComplaint);
            complaint.setDateOfDefect(dateOfDefect);
            complaint.setDaysToDetermination(daysToDetermination);
            complaint.setDefectDescription(defectDescription);
            complaint.setTypeOfDamage(typeOfDamage);
            complaint.setComments(comments);
            complaint.setAdvertiserExpectations(advertiserExpectations);
            complaint.setStatus(status);

            complaintService.updateComplaint(complaint);
        }
    }
    @DeleteMapping(path = "/complaint/{id}")
    void deleteById(@PathVariable Long id) {
        complaintService.deleteComplaintById(id);
    }


}

package pl.coderslab.applicationtomanagetheclaimsprecess.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.applicationtomanagetheclaimsprecess.entity.Complaint;
import pl.coderslab.applicationtomanagetheclaimsprecess.entity.Customer;
import pl.coderslab.applicationtomanagetheclaimsprecess.entity.Product;
import pl.coderslab.applicationtomanagetheclaimsprecess.service.ComplaintService;
import pl.coderslab.applicationtomanagetheclaimsprecess.service.CustomerService;
import pl.coderslab.applicationtomanagetheclaimsprecess.service.ProductService;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ComplaintFormController {


    private final ComplaintService complaintService;
    private final CustomerService customerService;
    private final ProductService productService;

    @GetMapping(path = "/complaint/list")
    public String showComplaints(Model model) {
        List<Complaint> complaints = complaintService.getAllComplaints();
        model.addAttribute("complaints", complaints);

        return "complaint/list";
    }

    @GetMapping(path = "/complaint/add")
    String showAddComplaintForm(Model model){
       model.addAttribute("complaint", new Complaint());
       return "complaint/add";
    }

    @PostMapping(path = "/complaint/add")
    String processAddComplaintForm(@Valid Complaint complaint, BindingResult bindingResult){
        Customer customer = complaint.getCustomer();
        Product product = complaint.getProduct();

        if (bindingResult.hasErrors()){
            return "complaint/add";
        }

        customerService.createCustomer(customer);
        productService.createProduct(product);
        complaintService.createComplaint(complaint);
        return "redirect:/complaint/list";
    }

    @GetMapping(path = "/complaint/edit")
    String showEditComplaintForm(@RequestParam Long id, Model model) {
        model.addAttribute("complaint", complaintService.getComplaintById(id));
        return "complaint/edit";
    }

    @PostMapping(path = "/complaint/edit")
    String processEditComplaintForm(@Valid Complaint complaint, BindingResult bindingResult) {
        Customer customer = complaint.getCustomer();
        Product product = complaint.getProduct();
        if(bindingResult.hasErrors()){
            return "complaint/edit";
        }
        customerService.updateCustomer(customer);
        productService.updateProduct(product);
        complaintService.updateComplaint(complaint);

        return "redirect:/complaint/list";
    }

    @GetMapping(path = "/complaint/remove")
    String processRemoveComplaint(@RequestParam Long id) {

        complaintService.deleteComplaintById(id);

        return "redirect:/complaint/list";
    }

//    @GetMapping("/complaints")
//    public ResponseEntity<String> getComplaintDeadline(@PathVariable("id") Long complaintId) {
//        Complaint complaint = complaintService.getComplaintById(complaintId);
//        LocalDate deadline = complaintService.calculateAndSetDeadline(complaint);
//        return ResponseEntity.ok(deadline);
//    }

    // Endpoint do obliczania dni do przeterminowania reklamacji
//    @GetMapping("/complaints/{id}/days-to-determination")
//    public int calculateDaysToDetermination(@PathVariable("id") Long complaintId) {
//        Complaint complaint = complaintService.getComplaintById(complaintId);
//        return complaintService.calculateDaysToDetermination(complaint);
//    }


    @ModelAttribute("status")
    public List<String> status() {
        return Arrays.asList("w toku", "rozpatrzona pozytywnie - wymiana",
                                "rozpatrzona pozytywnie - zwrot", "odrzucona");
    }

    @ModelAttribute("typeOfDamage")
    public List<String> typeOfDamage() {
        return Arrays.asList("pękanie", "prucie","uszkodzenia mechaniczne",
                "przecieranie", "jakość nadruku", "jakość materiału", "wadliwe akcesoria",
                "dziury", "przecieranie", "odbarwienia");
    }

    @ModelAttribute("advertiserExpectations")
    public List<String> advertiserExpectations() {
        return Arrays.asList("Zwrot środków", "Wymiana","Naprawa");
    }

}

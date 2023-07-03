package pl.coderslab.applicationtomanagetheclaimsprecess.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
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
import java.util.Date;
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

        for (Complaint complaint : complaints) {
            complaintService.calculateExpirationDate(complaint);
        }
        model.addAttribute("complaints", complaints);

        return "complaint/list";
    }

    @GetMapping(path = "/complaint/add")
    String showAddComplaintForm(Model model){
       model.addAttribute("complaint", new Complaint());
       return "complaint/add";
    }

    @PostMapping(path = "/complaint/add")
    String processAddComplaintForm(@Valid Complaint complaint,
                                   BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "complaint/add";
        }
        Customer customer = complaint.getCustomer();
        Product product = complaint.getProduct();

        customerService.createCustomer(customer);
        productService.createProduct(product);
        complaintService.createComplaint(complaint);
        return "redirect:/complaint/list";
    }

    @GetMapping(path = "/complaint/edit")
    String showEditComplaintForm(@RequestParam Long id, Model model) {
        Complaint complaint = complaintService.getComplaintById(id);
        LocalDate previousPurchaseDate = complaint.getProduct().getPurchaseDate();
        LocalDate previousDateOfComplaint = complaint.getDateOfComplaint();
        LocalDate previousDateOfDefect =complaint.getDateOfDefect();
        model.addAttribute("complaint", complaint);
        model.addAttribute("previousPurchaseDate", previousPurchaseDate);
        model.addAttribute("previousDateOfComplaint", previousDateOfComplaint);
        model.addAttribute("previousDateOfDefect", previousDateOfDefect);
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

    @GetMapping(path = "/complaint/search")
    String showSearchComplaintForm() {
        return "complaint/search";
    }


    //wyszukiwanie
    @GetMapping(path = "/complaint/search/customer", params = "lastName")
    String findByLastName(Customer customer, Model model) {

        List<Complaint> complaints = complaintService.findByLastName(customer.getLastName());
        model.addAttribute("complaints", complaints);

        return "complaint/list";
    }

    //ok działa
    @GetMapping(path = "/complaint/search", params = "state")
    public String findByState(@RequestParam("state") String state, Model model) {
        List<Complaint> complaints = complaintService.findByState(state);
        model.addAttribute("complaints", complaints);
        return "complaint/list";
    }


    @ModelAttribute("state")
    public List<String> state() {
        return Arrays.asList("w toku", "rozpatrzona pozytywnie - wymiana",
                                "rozpatrzona pozytywnie - zwrot", "odrzucona");
    }

    @ModelAttribute("typeOfDamage")
    public List<String> typeOfDamage() {
        return Arrays.asList("pękanie, prucie, przecieranie",
                "jakość nadruku, jakość materiału, wadliwe akcesoria",
                "dziury, odbarwienia");
    }

    @ModelAttribute("advertiserExpectations")
    public List<String> advertiserExpectations() {
        return Arrays.asList("Zwrot środków", "Wymiana","Naprawa");
    }

}

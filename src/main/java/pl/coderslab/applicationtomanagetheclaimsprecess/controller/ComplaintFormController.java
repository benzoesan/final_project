package pl.coderslab.applicationtomanagetheclaimsprecess.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.applicationtomanagetheclaimsprecess.entity.Complaint;
import pl.coderslab.applicationtomanagetheclaimsprecess.entity.Customer;
import pl.coderslab.applicationtomanagetheclaimsprecess.entity.Product;
import pl.coderslab.applicationtomanagetheclaimsprecess.service.ComplaintService;
import pl.coderslab.applicationtomanagetheclaimsprecess.service.CustomerService;
import pl.coderslab.applicationtomanagetheclaimsprecess.service.ProductService;

import java.util.Arrays;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ComplaintFormController {

    private final ComplaintService complaintService;
    private final CustomerService customerService;
    private final ProductService productService;

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

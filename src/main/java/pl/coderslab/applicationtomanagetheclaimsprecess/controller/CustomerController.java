package pl.coderslab.applicationtomanagetheclaimsprecess.controller;

import jakarta.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.applicationtomanagetheclaimsprecess.entity.Complaint;
import pl.coderslab.applicationtomanagetheclaimsprecess.entity.Customer;
import pl.coderslab.applicationtomanagetheclaimsprecess.entity.Product;
import pl.coderslab.applicationtomanagetheclaimsprecess.service.CustomerService;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Objects;

public class CustomerController {

    private final CustomerService customerService;


    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @PostMapping(path = "/customer")
    void save(@RequestParam String firstName, @RequestParam String lastName,@RequestParam String email, @RequestParam int phone){
        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setEmail(email);
        customer.setPhone(phone);

        customerService.createCustomer(customer);
    }

    @GetMapping(path = "/customer/{id}", produces = "text/plain;charset=utf-8")
    String findById(@PathVariable Long id){
        Customer customer = customerService.getCustomerById(id);
        return customer!=null ? customer.toString() : "Nie znaleziono klienta";
    }

    @PutMapping(path = "/customer/{id}")
    void update(@PathVariable Long id, @RequestParam String firstName, @RequestParam String lastName,@RequestParam String email, @RequestParam int phone){
        final Customer customer = customerService.getCustomerById(id);
        if (Objects.nonNull(customer)) {
            customer.setFirstName(firstName);
            customer.setLastName(lastName);
            customer.setEmail(email);
            customer.setPhone(phone);

            customerService.updateCustomer(customer);
        }
    }
    @DeleteMapping(path = "/customer/{id}")
    void deleteById(@PathVariable Long id) {
        customerService.deleteCustomerById(id);
    }


    @GetMapping(path = "/customer/add")
    String showAddCustomerForm(Model model){
        model.addAttribute("customer", new Customer());
        return "customer/add";
    }
    @PostMapping(path = "/customer/add")
    String processAddCustomerForm(@Valid Customer customer, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            return "customer/add";
        }

        customerService.createCustomer(customer);
        return "redirect:/customer/list";
    }
}

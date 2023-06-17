package pl.coderslab.applicationtomanagetheclaimsprecess.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.applicationtomanagetheclaimsprecess.entity.Customer;
import pl.coderslab.applicationtomanagetheclaimsprecess.repository.CustomerRepository;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomerService {
   private final CustomerRepository customerRepository;

   public Customer createCustomer (Customer customer) {
      // Dodawanie nowego klienta
      return customerRepository.save(customer);
   }

   public Customer getCustomerById(Long id) {
      // Pobieranie klienta po identyfikatorze
      return customerRepository.findById(id).get();
   }

   public void updateCustomer(Customer customer){
      customerRepository.save(customer);
   }

   public void deleteCustomerById(Long id){
      customerRepository.deleteById(id);
   }

   public List<Customer> getAllCustomers() {
      return customerRepository.findAll();
   }

}

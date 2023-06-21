package pl.coderslab.applicationtomanagetheclaimsprecess.service;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.coderslab.applicationtomanagetheclaimsprecess.entity.Product;
import pl.coderslab.applicationtomanagetheclaimsprecess.repository.ProductRepository;

@Component
@RequiredArgsConstructor
public class InitService {

    private final ProductRepository productRepository;

    @EventListener(ApplicationReadyEvent.class)
    void init(){
        productRepository.save(new Product());
        System.out.println("D");
        //Zapytani
    }
}

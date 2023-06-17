package pl.coderslab.applicationtomanagetheclaimsprecess.controller;

import org.springframework.web.bind.annotation.RestController;
import pl.coderslab.applicationtomanagetheclaimsprecess.service.ProductService;

@RestController
public class ProductController {

    private final ProductService productService;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }
}

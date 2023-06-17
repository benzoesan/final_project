package pl.coderslab.applicationtomanagetheclaimsprecess.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.applicationtomanagetheclaimsprecess.entity.Customer;
import pl.coderslab.applicationtomanagetheclaimsprecess.entity.Product;
import pl.coderslab.applicationtomanagetheclaimsprecess.repository.ProductRepository;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Product createProduct (Product product) {
        return productRepository.save(product);
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).get();
    }

    public void updateProduct(Product product){
        productRepository.save(product);
    }

    public void deleteProductById(Long id){
        productRepository.deleteById(id);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}

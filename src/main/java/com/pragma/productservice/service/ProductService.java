package com.pragma.productservice.service;

import com.pragma.productservice.model.Product;
import com.pragma.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Mono<Product> createProduct(Product product) {
        if (product.getName() == null || product.getName().isEmpty()) {
            return Mono.error(new IllegalArgumentException("Product name cannot be empty"));
        }
        if (product.getPrice() < 0) {
            return Mono.error(new IllegalArgumentException("Product price cannot be negative"));
        }
        return productRepository.findByName(product.getName())
               .filter(p ->!p.getId().equals(product.getId()))
               .switchIfEmpty(productRepository.save(product))
               .flatMap(savedProduct -> Mono.just(savedProduct));
    }

    public Flux<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Mono<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Mono<Product> updateProduct(Long id, Product product) {
        return productRepository.findById(id)
               .flatMap(existingProduct -> {
                    existingProduct.setName(product.getName());
                    existingProduct.setPrice(product.getPrice());
                    existingProduct.setStock(product.getStock());
                    existingProduct.setCategory(product.getCategory());
                    return productRepository.save(existingProduct);
                });
    }

    public Mono<ResponseEntity<?>> deleteProduct(Long id) {
        return productRepository.findById(id)
               .flatMap(productRepository::delete)
               .thenReturn(ResponseEntity.ok().build());
    }
}
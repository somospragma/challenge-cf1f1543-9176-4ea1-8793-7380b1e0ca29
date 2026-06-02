package com.pragma.productservice;

import com.pragma.productservice.controller.ProductController;
import com.pragma.productservice.model.Product;
import com.pragma.productservice.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@WebFluxTest(ProductController.class)
class ProductControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private ProductService productService;

    @Test
    void createProduct() {
        Product product = new Product();
        product.setName("Product 1");
        product.setPrice(10.0);
        product.setStock(100);
        product.setCategory("Category 1");

        when(productService.createProduct(any())).thenReturn(Mono.just(product));

        webTestClient.post()
               .uri("/api/products")
               .contentType(MediaType.APPLICATION_JSON)
               .bodyValue(product)
               .exchange()
               .expectStatus().isOk()
               .expectBody(Product.class);
    }

    @Test
    void getAllProducts() {
        Product product = new Product();
        product.setName("Product 1");
        product.setPrice(10.0);
        product.setStock(100);
        product.setCategory("Category 1");

        when(productService.getAllProducts()).thenReturn(Flux.just(product));

        webTestClient.get()
               .uri("/api/products")
               .exchange()
               .expectStatus().isOk()
               .expectBodyList(Product.class);
    }

    @Test
    void getProductById() {
        Product product = new Product();
        product.setId(1L);
        product.setName("Product 1");
        product.setPrice(10.0);
        product.setStock(100);
        product.setCategory("Category 1");

        when(productService.getProductById(1L)).thenReturn(Mono.just(product));

        webTestClient.get()
               .uri("/api/products/1")
               .exchange()
               .expectStatus().isOk()
               .expectBody(Product.class);
    }

    @Test
    void updateProduct() {
        Product product = new Product();
        product.setId(1L);
        product.setName("Product 1 Updated");
        product.setPrice(20.0);
        product.setStock(200);
        product.setCategory("Category 1 Updated");

        when(productService.updateProduct(1L, any())).thenReturn(Mono.just(product));

        webTestClient.put()
               .uri("/api/products/1")
               .contentType(MediaType.APPLICATION_JSON)
               .bodyValue(product)
               .exchange()
               .expectStatus().isOk()
               .expectBody(Product.class);
    }

    @Test
    void deleteProduct() {
        when(productService.deleteProduct(1L)).thenReturn(Mono.just(ResponseEntity.ok().build()));

        webTestClient.delete()
               .uri("/api/products/1")
               .exchange()
               .expectStatus().isOk();
    }
}
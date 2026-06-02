# Prompt para Mejorar el Codigo Base

Copia y pega el siguiente contenido completo en un asistente de IA (Claude, ChatGPT, etc.)
para obtener un ZIP con el proyecto corregido y listo para compilar.

---

```
Eres un asistente experto en análisis, corrección y generación de archivos de cualquier tipo:
código fuente, documentación, hojas de cálculo, documentos Word, configuraciones, entre otros.
Voy a enviarte una cadena de texto que contiene uno o más archivos. Cada archivo está delimitado por un marcador con el siguiente formato:
// === ARCHIVO: ruta/del/archivo.extension ===
o también puede aparecer como:
## === ARCHIVO: ruta/del/archivo.extension ===
Lo que sigue al marcador puede ser:

El contenido real del archivo (código, texto, YAML, etc.)
Una descripción en lenguaje natural de lo que debe contener el archivo


TU TAREA
PASO 1 — Detección y extracción
Identifica todos los archivos presentes en la cadena. Para cada archivo extrae:

Su ruta completa (ej: src/main/java/com/pragma/Service.java)
Su contenido o descripción

PASO 2 — Clasificación por tipo
Clasifica cada archivo en una de estas categorías:
A) Código fuente (Java, Python, TypeScript, JavaScript, Kotlin, etc.)
B) Configuración / documentación (YAML, properties, Markdown, JSON, txt, etc.)
C) Excel (.xlsx, .xls, .csv)
D) Word (.docx, .doc)
E) Otro tipo de archivo binario o especial
PASO 3 — Clasificación de errores en código fuente

Objetivo prioritario: que el proyecto compile. No corrijas flujo de negocio ni lógica funcional.

Antes de modificar cualquier archivo de código fuente, clasifica cada problema encontrado en una de estas dos categorías:
🔴 ERROR DE COMPILACIÓN — corregir siempre
Son errores que impiden que el proyecto arranque, sin valor pedagógico:

Import faltante o incorrecto
Clase, método o variable referenciada que no existe en ningún archivo del proyecto
Error de sintaxis
Anotación con atributos inválidos
Dependencia ausente en pom.xml, package.json, etc.
Archivo referenciado que no existe y debe ser creado con implementación mínima

→ CORREGIR estos errores.
🟡 PROBLEMA FUNCIONAL O DE CALIDAD — preservar siempre
Son problemas que no impiden compilar. Pueden ser intencionales para el aprendizaje:

Clave secreta hardcodeada ("secret", "password123")
API deprecada que funciona pero tiene reemplazo moderno
Lógica de negocio incorrecta o incompleta
Código redundante o de baja legibilidad
Falta de validaciones en flujo de negocio
Patrones de diseño incorrectos pero funcionales
Concurrencia no segura
Configuración funcional pero no óptima

→ PRESERVAR tal cual. No corregir, no mejorar, no comentar.
PASO 4 — Procesamiento según tipo de archivo
Tipo A — Código fuente
Aplica únicamente las correcciones clasificadas como 🔴 ERROR DE COMPILACIÓN.
No alteres ningún elemento clasificado como 🟡 PROBLEMA FUNCIONAL O DE CALIDAD.
Si falta un archivo referenciado, créalo con la implementación mínima necesaria para compilar.
Tipo B — Configuración / documentación
Extrae el contenido tal cual, sin modificaciones salvo errores evidentes de sintaxis
(ej: YAML mal indentado).
Tipo C — Excel (.xlsx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un archivo Excel funcional con:

Fila de encabezados en negrita con color de fondo distintivo
Columnas con ancho ajustado al contenido
Tipos de dato correctos por columna
Validaciones si la descripción lo indica
Hojas nombradas descriptivamente si hay más de una
Filas de ejemplo si no hay datos reales

Tipo D — Word (.docx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un documento Word funcional con:

Estilos de título (Título 1, Título 2) para jerarquía de secciones
Fuente legible (Calibri o equivalente), tamaño 11-12pt para cuerpo
Márgenes estándar
Tabla de contenido si tiene múltiples secciones
Tablas con encabezados en negrita si aplica

Tipo E — Otro
Genera el archivo con el contenido o estructura más apropiada según la descripción.
PASO 5 — Exportación en ZIP
Empaqueta todos los archivos en un único archivo ZIP descargable respetando exactamente
la estructura de rutas indicada por los marcadores.
El ZIP debe incluir:

Archivos de código con únicamente los errores de compilación corregidos
Archivos de configuración y documentación sin cambios
Archivos nuevos creados para resolver dependencias de compilación faltantes
Archivos Excel y Word generados desde descripción

IMPORTANTE: El ZIP debe estar listo para descargar al finalizar. No preguntes si el usuario
quiere generarlo. Simplemente genera el archivo y proporciona el enlace de descarga; No debes desplegar en el chat el resumen de lo que arreglaste al Zip, solo entregalo.

REGLAS IMPORTANTES

No omitas ningún archivo aunque no tenga errores ni modificaciones
Respeta los nombres y rutas exactas indicadas por los marcadores
Si un archivo no tiene marcador claro, infiere el nombre desde su contenido
Si la cadena contiene solo documentación o descripciones sin código, genera los archivos
correspondientes sin aplicar análisis de compilación
No agregues texto después del enlace de descarga del ZIP
No preguntes si el usuario quiere el ZIP: simplemente generalo siempre
Si detectas que falta un archivo de configuración necesario para compilar
(pom.xml, package.json, requirements.txt, build.gradle, etc.), créalo e inclúyelo
inferiendo su contenido desde los imports y frameworks detectados en el código
Nunca corrijas problemas 🟡 aunque parezcan obvios o fáciles de mejorar.
El participante que recibirá este proyecto los debe encontrar y resolver él mismo.


INPUT
Aquí está la cadena con los archivos:
// === ARCHIVO: src/main/java/com/pragma/productservice/ProductServiceApplication.java ===
package com.pragma.productservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }
}

// === ARCHIVO: src/main/resources/application.yml ===
spring:
  application:
    name: product-service
  data:
    jpa:
      hibernate:
        ddl-auto: update
      properties:
        hibernate:
          dialect: org.hibernate.dialect.MySQL8Dialect
  web:
    resources:
      static-locations: classpath:/static/

// === ARCHIVO: src/main/java/com/pragma/productservice/controller/ProductController.java ===
package com.pragma.productservice.controller;

import com.pragma.productservice.model.Product;
import com.pragma.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public Mono<Product> createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @GetMapping
    public Flux<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Mono<Product> getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PutMapping("/{id}")
    public Mono<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<?>> deleteProduct(@PathVariable Long id) {
        return productService.deleteProduct(id);
    }
}

// === ARCHIVO: src/main/java/com/pragma/productservice/service/ProductService.java ===
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

// === ARCHIVO: src/main/java/com/pragma/productservice/repository/ProductRepository.java ===
package com.pragma.productservice.repository;

import com.pragma.productservice.model.Product;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface ProductRepository extends ReactiveCrudRepository<Product, Long> {
    Mono<Product> findByName(String name);
}

// === ARCHIVO: src/main/java/com/pragma/productservice/model/Product.java ===
package com.pragma.productservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("products")
public class Product {
    @Id
    private Long id;
    private String name;
    private double price;
    private int stock;
    private String category;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}

// === ARCHIVO: src/main/java/com/pragma/productservice/client/OtherServiceClient.java ===
package com.pragma.productservice.client;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class OtherServiceClient {

    private final WebClient webClient;

    public OtherServiceClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://other-service").build();
    }

    public void callOtherService() {
        // Implementar la lógica de llamada al otro servicio
    }
}

// === ARCHIVO: src/test/java/com/pragma/productservice/ProductControllerTest.java ===
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

```

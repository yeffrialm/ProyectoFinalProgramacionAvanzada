package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.controller;


import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.request.product.CreateProductRequest;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.request.product.DeleteProductRequest;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.request.product.UpdateProductRequest;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.response.product.CreateProductResponse;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.response.product.DeleteProductResponse;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.response.product.GetProductResponse;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.response.product.UpdateProductResponse;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author jelfry on 7/09/2022.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<GetProductResponse> get() {
        return ResponseEntity.ok(GetProductResponse.builder()
                .products(productService.getAll())
                .build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetProductResponse> get(@PathVariable Long id) {
        return ResponseEntity.ok(GetProductResponse.builder()
                .products(List.of(productService.get(id)))
                .build());
    }

    @PostMapping
    public ResponseEntity<CreateProductResponse> create(@RequestBody CreateProductRequest createProductRequest) {
        return ResponseEntity.ok(CreateProductResponse.builder()
                .product(productService.create(createProductRequest))
                .build());
    }

    @PutMapping
    public ResponseEntity<UpdateProductResponse> update(@RequestBody UpdateProductRequest updateProductRequest) {
        return ResponseEntity.ok(UpdateProductResponse.builder()
                .product(productService.update(updateProductRequest))
                .build());
    }

    @DeleteMapping
    public ResponseEntity<DeleteProductResponse> delete(@RequestBody DeleteProductRequest deleteProductRequest) {
        productService.delete(deleteProductRequest);
        return ResponseEntity.ok(DeleteProductResponse.builder().build());
    }
}

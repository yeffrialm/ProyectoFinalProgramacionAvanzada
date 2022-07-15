package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.services;


import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.domain.Product;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.dto.ProductDTO;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.request.product.CreateProductRequest;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.request.product.DeleteProductRequest;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.request.product.UpdateProductRequest;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author jelfry on 7/09/2022.
 */
@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<ProductDTO> getAll() {
        return productRepository.findAll().stream().map(Product::toDTO).collect(Collectors.toList());
    }

    public ProductDTO get(Long id) {
        return productRepository.findById(id).orElseThrow().toDTO();
    }

    public ProductDTO create(CreateProductRequest createProductRequest) {
        Product product = productRepository.save(createProductRequest.toProduct());
        return product.toDTO();
    }

    public ProductDTO update(UpdateProductRequest updateProductRequest) {
        Product product = productRepository.findById(updateProductRequest.getId()).orElseThrow();
        product.applyChanges(updateProductRequest);
        productRepository.save(product);
        return product.toDTO();
    }

    public void delete(DeleteProductRequest deleteProductRequest) {
        productRepository.deleteById(deleteProductRequest.getId());
    }
}

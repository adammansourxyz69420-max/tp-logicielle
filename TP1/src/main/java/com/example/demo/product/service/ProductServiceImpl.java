package com.example.demo.product.service;

import com.example.demo.product.dto.CreateProductRequest;
import com.example.demo.product.dto.ProductDTO;
import com.example.demo.product.mapper.ProductMapper;
import com.example.demo.product.model.Product;
import com.example.demo.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;
    private final ProductMapper mapper;

    @Override
    public List<ProductDTO> getAllProducts() {
        return mapper.toDTOList(repository.findAll());
    }

    @Override
    public ProductDTO getProductById(Long id) {
        Product product = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
        return mapper.toDTO(product);
    }

    @Override
    public ProductDTO createProduct(CreateProductRequest request) {
        Product product = mapper.toEntity(request);
        Product saved = repository.save(product);
        return mapper.toDTO(saved);
    }

    @Override
    public ProductDTO updateProduct(Long id, CreateProductRequest request) {
        Product product = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
        mapper.updateEntity(request, product);
        Product updated = repository.save(product);
        return mapper.toDTO(updated);
    }

    @Override
    public void deleteProduct(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Product not found with id: " + id);
        }
        repository.deleteById(id);
    }
}
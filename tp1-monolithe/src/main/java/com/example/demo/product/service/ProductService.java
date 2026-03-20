package com.example.demo.product.service;

import com.example.demo.product.dto.CreateProductRequest;
import com.example.demo.product.dto.ProductDTO;
import java.util.List;

public interface ProductService {
    List<ProductDTO> getAllProducts();
    ProductDTO getProductById(Long id);
    ProductDTO createProduct(CreateProductRequest request);
    ProductDTO updateProduct(Long id, CreateProductRequest request);
    void deleteProduct(Long id);
}

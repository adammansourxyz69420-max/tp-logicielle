package com.example.demo.product.mapper;

import com.example.demo.product.dto.CreateProductRequest;
import com.example.demo.product.dto.ProductDTO;
import com.example.demo.product.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDTO toDTO(Product product);

    List<ProductDTO> toDTOList(List<Product> products);

    Product toEntity(CreateProductRequest request);

    @Mapping(target = "id", ignore = true)
    void updateEntity(CreateProductRequest request, @MappingTarget Product product);
}
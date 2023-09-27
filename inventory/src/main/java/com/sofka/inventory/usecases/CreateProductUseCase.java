package com.sofka.inventory.usecases;

import com.sofka.inventory.dtos.BranchDTO;
import com.sofka.inventory.dtos.ProductDTO;
import com.sofka.inventory.model.Branch;
import com.sofka.inventory.model.Product;
import com.sofka.inventory.repository.ProductRepository;
import com.sofka.inventory.utilities.MapperUtils;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Data
@Service
@RequiredArgsConstructor
public class CreateProductUseCase {
    private final MapperUtils mapperUtils;
    private final ProductRepository productRepository;

    public Mono<Product> createProduct(ProductDTO productDTO){
        return productRepository.save(mapperUtils.mapperToProduct().apply(productDTO));
    }
}

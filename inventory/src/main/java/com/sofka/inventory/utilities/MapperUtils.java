package com.sofka.inventory.utilities;

import com.sofka.inventory.dtos.BranchDTO;
import com.sofka.inventory.dtos.ProductDTO;
import com.sofka.inventory.model.Branch;
import com.sofka.inventory.model.Product;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.function.Function;

@Service
public class MapperUtils {
    public Function<BranchDTO, Branch> mapperToBranch(){
        return branchDTO -> {
            Branch branch = new Branch();
            branch.setBranchId(UUID.randomUUID().toString());
            branch.setBranchName(branchDTO.getBranchName());
            branch.setBranchLocation(branchDTO.getBranchLocation());

            return branch;

        };
    }

    public Function<ProductDTO, Product> mapperToProduct(){
        return productDTO -> {
            Product product = new Product();
            product.setProductId(UUID.randomUUID().toString());
            product.setProductName(productDTO.getProductName());
            product.setProductDescription(productDTO.getProductDescription());
            product.setProductPrice(productDTO.getProductPrice());
            product.setProductInventoryStock(productDTO.getProductInventoryStock());
            product.setProductCategory(productDTO.getProductCategory());

            return product;

        };
    }
}

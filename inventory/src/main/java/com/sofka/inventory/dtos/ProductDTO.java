package com.sofka.inventory.dtos;

import lombok.Data;

@Data
public class ProductDTO {
    private String productName;
    private String productDescription;
    private Float productPrice;
    private Integer productInventoryStock;
    private String productCategory;


}

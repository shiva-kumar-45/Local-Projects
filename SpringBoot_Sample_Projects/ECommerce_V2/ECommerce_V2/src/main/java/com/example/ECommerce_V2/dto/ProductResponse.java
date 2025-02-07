package com.example.ECommerce_V2.dto;

import lombok.Data;

import java.util.List;

@Data
public class ProductResponse {

    private List<ProductDTO> content;
    private Integer pageNumber;
    private Integer pageSize;
    private Long totalElements;
    private Integer totalPages;
    private boolean lastPage;
}

package com.example.ECommerce_V2.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserResponse {

    private List<UserDTO> content;
    private Integer pageNumber;
    private Integer pageSize;
    private Long totalElements;
    private Integer totalPages;
    private boolean lastPage;
}

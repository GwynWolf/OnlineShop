package com.onlineshop.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CategoryCreateDto {
    @NotBlank
    private String name;
    private Long parentId;
    @NotNull
    private Boolean visible;
    @NotBlank
    private String url;

}

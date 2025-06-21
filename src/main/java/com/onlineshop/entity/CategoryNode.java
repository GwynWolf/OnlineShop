package com.onlineshop.entity;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@RequiredArgsConstructor
public class CategoryNode {
    @NonNull
    private Category category;
    private List<CategoryNode> children = new ArrayList<>();
}

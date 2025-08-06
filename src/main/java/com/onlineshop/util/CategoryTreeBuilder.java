package com.onlineshop.util;

import com.onlineshop.entity.Category;
import com.onlineshop.entity.CategoryNode;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CategoryTreeBuilder {

    public List<CategoryNode> buildCategoryTree(List<Category> categories) {
        Map<Long, CategoryNode> map = new HashMap<>();
        List<CategoryNode> roots = new ArrayList<>();

        for (Category c : categories) {
            map.put(c.getId(), new CategoryNode(c));
        }

        for (Category c : categories) {
            CategoryNode node = map.get(c.getId());
            if (c.getParentId() == null || c.getParentId() == 0) {
                roots.add(node);
            } else {
                CategoryNode parentNode = map.get(c.getParentId());
                if (parentNode != null) {
                    parentNode.getChildren().add(node);
                    node.setParentId(parentNode.getId());
                } else {
                    roots.add(node);
                }
            }
        }
        return roots;
    }

    public CategoryNode findSubtreeNode(List<CategoryNode> nodes, Long parentId) {
        for (CategoryNode node : nodes) {
            if (node.getId().equals(parentId)) {
                return node;
            }
            CategoryNode found = findSubtreeNode(node.getChildren(), parentId);
            if (found != null) {
                return found;
            }
        }
        return null;
    }
}

package com.onlineshop.dao;

import com.onlineshop.entity.Images;

import java.util.List;

public interface ImagesDAO {
    public List<Images> getImagesByProductID(int productID);
}

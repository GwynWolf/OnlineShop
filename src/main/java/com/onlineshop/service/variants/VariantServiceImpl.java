package com.onlineshop.service.variants;

import com.onlineshop.dao.variants.VariantsDAO;
import com.onlineshop.entity.Variants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VariantServiceImpl implements VariantService {

    @Autowired
    private VariantsDAO variantsDAO;

    @Override
    public List<Variants> getByProductID(int productID) {
        return variantsDAO.getByProductID(productID);
    }

    @Override
    public Variants getById(int id) {
        return variantsDAO.getById(id);
    }

    @Override
    public void save(Variants variants) {
        variantsDAO.save(variants);
    }

    @Override
    public void update(Variants variants) {
        variantsDAO.save(variants);
    }

    @Override
    public void delete(Variants variants) {
        variantsDAO.delete(variants);
    }

    @Override
    public void delete(int id) {
        variantsDAO.delete(id);
    }
}

package com.fatihkimukin.ecom.service;

import com.fatihkimukin.ecom.entity.Product;
import com.fatihkimukin.ecom.general.BaseEntityService;
import com.fatihkimukin.ecom.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService extends BaseEntityService<Product, ProductRepository> {

    public ProductService(ProductRepository repository) {
        super(repository);
    }
}

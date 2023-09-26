package com.fatihkimukin.ecom.controller.contract;

import com.fatihkimukin.ecom.dto.product.ProductDTO;
import com.fatihkimukin.ecom.dto.product.ProductSaveRequest;
import com.fatihkimukin.ecom.dto.product.ProductUpdatePriceRequest;

import java.util.List;

public interface ProductControllerContract {

    ProductDTO save(ProductSaveRequest productSaveRequest);

    List<ProductDTO> findAll();

    ProductDTO findById(Long id);

    void deleteById(Long id);

    ProductDTO updatePriceById(Long id, ProductUpdatePriceRequest productUpdatePriceRequest);
}

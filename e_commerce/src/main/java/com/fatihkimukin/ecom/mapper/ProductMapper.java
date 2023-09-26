package com.fatihkimukin.ecom.mapper;

import com.fatihkimukin.ecom.dto.product.ProductDTO;
import com.fatihkimukin.ecom.dto.product.ProductSaveRequest;
import com.fatihkimukin.ecom.entity.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product convertToProduct(ProductSaveRequest productSaveRequest);

    ProductDTO convertToProductDTO(Product product);

    List<ProductDTO> convertToProductDTOList(List<Product> productList);

    List<Product> convertToProductList(List<ProductDTO> productDTOListDTO);
}

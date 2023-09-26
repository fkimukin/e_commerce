package com.fatihkimukin.ecom.mapper;

import com.fatihkimukin.ecom.dto.product.ProductDTO;
import com.fatihkimukin.ecom.dto.product.ProductSaveRequest;
import com.fatihkimukin.ecom.entity.Product;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-27T00:40:45+0300",
    comments = "version: 1.5.1.Final, compiler: javac, environment: Java 19.0.2 (Amazon.com Inc.)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Product convertToProduct(ProductSaveRequest productSaveRequest) {
        if ( productSaveRequest == null ) {
            return null;
        }

        Product product = new Product();

        product.setName( productSaveRequest.name() );
        product.setPrice( productSaveRequest.price() );
        product.setDescription( productSaveRequest.description() );

        return product;
    }

    @Override
    public ProductDTO convertToProductDTO(Product product) {
        if ( product == null ) {
            return null;
        }

        Long id = null;
        String name = null;
        BigDecimal price = null;
        String description = null;

        id = product.getId();
        name = product.getName();
        price = product.getPrice();
        description = product.getDescription();

        ProductDTO productDTO = new ProductDTO( id, name, price, description );

        return productDTO;
    }

    @Override
    public List<ProductDTO> convertToProductDTOList(List<Product> productList) {
        if ( productList == null ) {
            return null;
        }

        List<ProductDTO> list = new ArrayList<ProductDTO>( productList.size() );
        for ( Product product : productList ) {
            list.add( convertToProductDTO( product ) );
        }

        return list;
    }

    @Override
    public List<Product> convertToProductList(List<ProductDTO> productDTOListDTO) {
        if ( productDTOListDTO == null ) {
            return null;
        }

        List<Product> list = new ArrayList<Product>( productDTOListDTO.size() );
        for ( ProductDTO productDTO : productDTOListDTO ) {
            list.add( productDTOToProduct( productDTO ) );
        }

        return list;
    }

    protected Product productDTOToProduct(ProductDTO productDTO) {
        if ( productDTO == null ) {
            return null;
        }

        Product product = new Product();

        product.setId( productDTO.id() );
        product.setName( productDTO.name() );
        product.setPrice( productDTO.price() );
        product.setDescription( productDTO.description() );

        return product;
    }
}

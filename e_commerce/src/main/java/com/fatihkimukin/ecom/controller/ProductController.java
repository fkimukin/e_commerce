package com.fatihkimukin.ecom.controller;

import com.fatihkimukin.ecom.dto.product.ProductDTO;
import com.fatihkimukin.ecom.dto.product.ProductSaveRequest;
import com.fatihkimukin.ecom.dto.product.ProductUpdatePriceRequest;
import com.fatihkimukin.ecom.general.RestResponse;
import com.fatihkimukin.ecom.controller.contract.ProductControllerContract;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductControllerContract productControllerContract;

    @PostMapping
    public ResponseEntity<RestResponse<ProductDTO>> save(@RequestBody ProductSaveRequest productSaveRequest){
        var productDTO = productControllerContract.save(productSaveRequest);
        return ResponseEntity.ok(RestResponse.of(productDTO));
    }

    @GetMapping
    public ResponseEntity<RestResponse<List<ProductDTO>>> findAll(){
        List<ProductDTO> productDTOList = productControllerContract.findAll();
        return ResponseEntity.ok(RestResponse.of(productDTOList));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestResponse<ProductDTO>> findById(@PathVariable Long id){
        ProductDTO productDTO = productControllerContract.findById(id);
        return ResponseEntity.ok(RestResponse.of(productDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RestResponse<Object>> deleteById(@PathVariable Long id){
        productControllerContract.deleteById(id);
        return ResponseEntity.ok(RestResponse.empty());
    }

    @PutMapping("/{id}")
    public ResponseEntity<RestResponse<ProductDTO>> updatePriceById(@PathVariable Long id, @RequestBody ProductUpdatePriceRequest request){
        ProductDTO productDTO = productControllerContract.updatePriceById(id, request);
        return ResponseEntity.ok(RestResponse.of(productDTO));
    }
}



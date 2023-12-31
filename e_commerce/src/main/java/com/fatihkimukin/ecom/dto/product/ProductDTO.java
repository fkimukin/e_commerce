package com.fatihkimukin.ecom.dto.product;

import java.math.BigDecimal;

public record ProductDTO(Long id,
                         String name,
                         BigDecimal price,
                         String description
                         ) {
}

package com.fatihkimukin.ecom.dto.product;

import java.math.BigDecimal;

public record ProductSaveRequest(String name,
                                 BigDecimal price,
                                 String description
                                 ) {
}

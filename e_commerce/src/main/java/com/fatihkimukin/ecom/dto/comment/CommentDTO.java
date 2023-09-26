package com.fatihkimukin.ecom.dto.comment;

public record CommentDTO(Long id,
                         String comment,
                         Long productId,
                         Long userId
                         ) {
}

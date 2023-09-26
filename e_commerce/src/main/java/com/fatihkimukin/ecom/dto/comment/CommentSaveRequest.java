package com.fatihkimukin.ecom.dto.comment;

public record CommentSaveRequest(String comment,
                                 Long productId,
                                 Long userId
                                 ) {
}

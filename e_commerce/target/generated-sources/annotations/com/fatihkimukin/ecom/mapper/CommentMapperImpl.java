package com.fatihkimukin.ecom.mapper;

import com.fatihkimukin.ecom.dto.comment.CommentDTO;
import com.fatihkimukin.ecom.dto.comment.CommentSaveRequest;
import com.fatihkimukin.ecom.entity.Comment;
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
public class CommentMapperImpl implements CommentMapper {

    @Override
    public List<CommentDTO> convertToCommentDtoList(List<Comment> commentList) {
        if ( commentList == null ) {
            return null;
        }

        List<CommentDTO> list = new ArrayList<CommentDTO>( commentList.size() );
        for ( Comment comment : commentList ) {
            list.add( convertToCommentDTO( comment ) );
        }

        return list;
    }

    @Override
    public CommentDTO convertToCommentDTO(Comment comment) {
        if ( comment == null ) {
            return null;
        }

        Long id = null;
        String comment1 = null;
        Long productId = null;
        Long userId = null;

        id = comment.getId();
        comment1 = comment.getComment();
        productId = comment.getProductId();
        userId = comment.getUserId();

        CommentDTO commentDTO = new CommentDTO( id, comment1, productId, userId );

        return commentDTO;
    }

    @Override
    public Comment convertToComment(CommentSaveRequest commentSaveRequest) {
        if ( commentSaveRequest == null ) {
            return null;
        }

        Comment comment = new Comment();

        comment.setComment( commentSaveRequest.comment() );
        comment.setProductId( commentSaveRequest.productId() );
        comment.setUserId( commentSaveRequest.userId() );

        return comment;
    }
}

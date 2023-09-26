package com.fatihkimukin.ecom.mapper;

import com.fatihkimukin.ecom.dto.comment.CommentDTO;
import com.fatihkimukin.ecom.dto.comment.CommentSaveRequest;
import com.fatihkimukin.ecom.entity.Comment;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    List<CommentDTO> convertToCommentDtoList(List<Comment> commentList);

    CommentDTO convertToCommentDTO(Comment comment);

    Comment convertToComment(CommentSaveRequest commentSaveRequest);

}

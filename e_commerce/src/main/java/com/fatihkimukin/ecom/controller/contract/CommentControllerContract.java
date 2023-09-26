package com.fatihkimukin.ecom.controller.contract;

import com.fatihkimukin.ecom.dto.comment.CommentDTO;
import com.fatihkimukin.ecom.dto.comment.CommentSaveRequest;

import java.util.List;

public interface CommentControllerContract {

    List<CommentDTO> findAll();

    CommentDTO findById(Long id);

    CommentDTO save(CommentSaveRequest commentSaveRequest);

    void deleteById(Long id);

    List<CommentDTO> findUserComments(Long customerId);

    List<CommentDTO> findProductComments(Long productId);
}

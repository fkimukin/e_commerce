package com.fatihkimukin.ecom.service;

import com.fatihkimukin.ecom.entity.Comment;
import com.fatihkimukin.ecom.general.BaseEntityService;
import com.fatihkimukin.ecom.repository.CommentRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Getter
@Setter
public class CommentService extends BaseEntityService<Comment, CommentRepository> {

    private CommentRepository repository;

    public CommentService(CommentRepository repository) {
        super(repository);
        this.repository=repository;
    }

    public List<Comment> findCommentsByUserId(Long userId){
        return repository.findCommentsByUserId(userId);
    }

    public List<Comment> findCommentsByProductId(Long productId){
        return repository.findCommentsByProductId(productId);
    }
}


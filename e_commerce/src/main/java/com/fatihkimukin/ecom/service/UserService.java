package com.fatihkimukin.ecom.service;

import com.fatihkimukin.ecom.entity.User;
import com.fatihkimukin.ecom.general.BaseEntityService;
import com.fatihkimukin.ecom.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseEntityService<User, UserRepository> {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public User findByUsername(String username){
        return repository.findByUsername(username);
    }

    public boolean existByUsername(String username){
        return repository.existsByUsername(username);
    }

    public boolean existByEmail(String email){
        return repository.existsByEmail(email);
    }

    public User findUserByUsername(String username){
        return repository.findUserByUsername(username);
    }


}

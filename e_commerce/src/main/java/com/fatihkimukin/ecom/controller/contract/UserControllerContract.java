package com.fatihkimukin.ecom.controller.contract;

import com.fatihkimukin.ecom.dto.user.UserDTO;
import com.fatihkimukin.ecom.dto.user.UserDeleteRequest;
import com.fatihkimukin.ecom.dto.user.UserSaveRequest;

import java.util.List;


public interface UserControllerContract {

    List<UserDTO> findAll();

    UserDTO findById(Long id);

    UserDTO findByUsername(String username);

    UserDTO save(UserSaveRequest userSaveRequest);

    UserDTO updateById(Long id, UserSaveRequest userSaveRequest);



    void deleteById(Long id, UserDeleteRequest userDeleteRequest);



}

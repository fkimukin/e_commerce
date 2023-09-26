package com.fatihkimukin.ecom.controller.contract.impl;

import com.fatihkimukin.ecom.controller.contract.UserControllerContract;
import com.fatihkimukin.ecom.dto.user.UserDTO;
import com.fatihkimukin.ecom.dto.user.UserDeleteRequest;
import com.fatihkimukin.ecom.dto.user.UserSaveRequest;
import com.fatihkimukin.ecom.entity.User;
import com.fatihkimukin.ecom.errormessages.UserErrorMessage;
import com.fatihkimukin.ecom.general.BusinessException;
import com.fatihkimukin.ecom.general.ItemNotFoundException;
import com.fatihkimukin.ecom.mapper.UserMapper;
import com.fatihkimukin.ecom.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserControllerContractImpl implements UserControllerContract {

    private final UserService userService;
    private final UserMapper mapper;

    @Override
    public List<UserDTO> findAll() {
        List<User> userList = userService.findAll();
        return mapper.convertToUserDTOList(userList);
    }

    @Override
    public UserDTO findById(Long id) {
        User user;

        Optional<User> optionalUser = userService.findById(id);
        if (optionalUser.isPresent()) {
            user = optionalUser.get();
        } else {
            throw new ItemNotFoundException(UserErrorMessage.USER_NOT_FOUND);
        }
        return mapper.convertToUserDTO(user);
    }

    @Override
    public UserDTO findByUsername(String username) {
        User user = userService.findByUsername(username);
        return mapper.convertToUserDTO(user);
    }

    @Override
    public UserDTO save(UserSaveRequest userSaveRequest) {
        User user = mapper.convertToUser(userSaveRequest);

        boolean isEmailAndUserNameTaken = userService.existByUsername(user.getUsername()) && userService.existByEmail(user.getEmail());
        boolean isEmailTaken = userService.existByEmail(user.getEmail());
        boolean isUserNameTaken = userService.existByUsername(user.getUsername());

        if (isEmailAndUserNameTaken) {
            throw new BusinessException(UserErrorMessage.EMAIL_AND_USERNAME_ARE_TAKEN);
        } else if (isUserNameTaken) {
            throw new BusinessException(UserErrorMessage.USERNAME_IS_TAKEN);
        } else if (isEmailTaken) {
            throw new BusinessException(UserErrorMessage.EMAIL_IS_TAKEN);
        } else {
            userService.save(user);
            return mapper.convertToUserDTO(user);
        }
    }

    @Override
    public UserDTO updateById(Long id, UserSaveRequest userSaveRequest) {
        User user = null;

        Optional<User> optionalUser = userService.findById(id);
        if (optionalUser.isPresent()) {
            user = optionalUser.get();
        } else {
            throw new ItemNotFoundException(UserErrorMessage.USER_NOT_FOUND);
        }

        boolean isEmailAndUserNameTaken = userService.existByUsername(user.getUsername()) && userService.existByEmail(user.getEmail());
        boolean isEmailTaken = userService.existByEmail(user.getEmail());
        boolean isUserNameTaken = userService.existByUsername(user.getUsername());

        if (isEmailAndUserNameTaken) {
            throw new BusinessException(UserErrorMessage.EMAIL_AND_USERNAME_ARE_TAKEN);
        } else if (isUserNameTaken) {
            throw new BusinessException(UserErrorMessage.USERNAME_IS_TAKEN);
        } else if (isEmailTaken) {
            throw new BusinessException(UserErrorMessage.EMAIL_IS_TAKEN);
        } else {
            user = mapper.convertToUser(userSaveRequest);
            userService.save(user);
            return mapper.convertToUserDTO(user);
        }
    }


    @Override
    public void deleteById(Long id, UserDeleteRequest userDeleteRequest) {

        User user = userService.findByIdWithControl(id);

        if (!user.getUsername().equals(userDeleteRequest.username())
                && !user.getPhoneNumber().equals(userDeleteRequest.phoneNumber())) {
            throw new BusinessException(UserErrorMessage.USERNAME_AND_PHONE_NUMBER_DOES_NOT_MATCH);
        }

        userService.deleteById(id);
    }
}

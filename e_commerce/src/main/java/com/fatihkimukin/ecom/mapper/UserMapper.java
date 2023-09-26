package com.fatihkimukin.ecom.mapper;

import com.fatihkimukin.ecom.dto.user.UserDTO;
import com.fatihkimukin.ecom.dto.user.UserSaveRequest;
import com.fatihkimukin.ecom.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    List<UserDTO> convertToUserDTOList(List<User> userList);

    UserDTO convertToUserDTO(User user);

    User convertToUser(UserSaveRequest userSaveRequest);



}

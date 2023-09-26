package com.fatihkimukin.ecom.mapper;

import com.fatihkimukin.ecom.dto.user.UserDTO;
import com.fatihkimukin.ecom.dto.user.UserSaveRequest;
import com.fatihkimukin.ecom.entity.User;
import com.fatihkimukin.ecom.enums.EnumUserType;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-27T00:40:44+0300",
    comments = "version: 1.5.1.Final, compiler: javac, environment: Java 19.0.2 (Amazon.com Inc.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public List<UserDTO> convertToUserDTOList(List<User> userList) {
        if ( userList == null ) {
            return null;
        }

        List<UserDTO> list = new ArrayList<UserDTO>( userList.size() );
        for ( User user : userList ) {
            list.add( convertToUserDTO( user ) );
        }

        return list;
    }

    @Override
    public UserDTO convertToUserDTO(User user) {
        if ( user == null ) {
            return null;
        }

        Long id = null;
        String firstName = null;
        String lastName = null;
        String username = null;
        String email = null;
        String phoneNumber = null;
        EnumUserType userType = null;

        id = user.getId();
        firstName = user.getFirstName();
        lastName = user.getLastName();
        username = user.getUsername();
        email = user.getEmail();
        phoneNumber = user.getPhoneNumber();
        userType = user.getUserType();

        UserDTO userDTO = new UserDTO( id, firstName, lastName, username, email, phoneNumber, userType );

        return userDTO;
    }

    @Override
    public User convertToUser(UserSaveRequest userSaveRequest) {
        if ( userSaveRequest == null ) {
            return null;
        }

        User user = new User();

        user.setFirstName( userSaveRequest.firstName() );
        user.setLastName( userSaveRequest.lastName() );
        user.setUsername( userSaveRequest.username() );
        user.setPassword( userSaveRequest.password() );
        user.setEmail( userSaveRequest.email() );
        user.setPhoneNumber( userSaveRequest.phoneNumber() );
        user.setUserType( userSaveRequest.userType() );

        return user;
    }
}

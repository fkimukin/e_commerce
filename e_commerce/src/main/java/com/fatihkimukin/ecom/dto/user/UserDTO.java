package com.fatihkimukin.ecom.dto.user;

import com.fatihkimukin.ecom.enums.EnumUserType;

public record UserDTO(Long id,
                      String firstName,
                      String lastName,
                      String username,
                      String email,
                      String phoneNumber,
                      EnumUserType userType
                      ) {
}

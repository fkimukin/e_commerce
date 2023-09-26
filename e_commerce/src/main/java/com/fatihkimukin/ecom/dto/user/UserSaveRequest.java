package com.fatihkimukin.ecom.dto.user;

import com.fatihkimukin.ecom.enums.EnumUserType;

public record UserSaveRequest(String firstName,
                              String lastName,
                              String username,
                              String password,
                              String email,
                              String phoneNumber,
                              EnumUserType userType
                              ) {
}

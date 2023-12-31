package com.fatihkimukin.ecom.controller;

import com.fatihkimukin.ecom.dto.user.UserDTO;
import com.fatihkimukin.ecom.dto.user.UserDeleteRequest;
import com.fatihkimukin.ecom.dto.user.UserSaveRequest;
import com.fatihkimukin.ecom.general.RestResponse;
import com.fatihkimukin.ecom.controller.contract.UserControllerContract;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserControllerContract userControllerContract;

    @PostMapping
    ResponseEntity<RestResponse<UserDTO>> save(@RequestBody UserSaveRequest userSaveRequest){
        UserDTO userDTO = userControllerContract.save(userSaveRequest);
        return ResponseEntity.ok(RestResponse.of(userDTO));
    }

    @GetMapping
    ResponseEntity<RestResponse<List<UserDTO>>> findAll(){
        List<UserDTO> userDTOList = userControllerContract.findAll();
        return ResponseEntity.ok(RestResponse.of(userDTOList));
    }

    @GetMapping("/{id}")
    ResponseEntity<RestResponse<UserDTO>> findById(@PathVariable Long id){
        UserDTO userDTO = userControllerContract.findById(id);
        return ResponseEntity.ok(RestResponse.of(userDTO));
    }

    @GetMapping("/username")
    ResponseEntity<RestResponse<UserDTO>> findByUsername(@RequestParam String username){
        UserDTO userDTO = userControllerContract.findByUsername(username);
        return ResponseEntity.ok(RestResponse.of(userDTO));
    }


    @DeleteMapping("/{id}")
    ResponseEntity<RestResponse<Object>> deleteById(@PathVariable Long id, @RequestBody UserDeleteRequest userDeleteRequest){
        userControllerContract.deleteById(id,userDeleteRequest);
        return ResponseEntity.ok(RestResponse.empty());
    }


    @PutMapping("/{id}")
    ResponseEntity<RestResponse<UserDTO>> updateById(@PathVariable Long id, @RequestBody UserSaveRequest userSaveRequest){
       userControllerContract.updateById(id, userSaveRequest);
        return null;
    }

}

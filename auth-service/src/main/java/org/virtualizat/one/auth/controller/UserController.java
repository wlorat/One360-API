package org.virtualizat.one.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.virtualizat.one.auth.dto.APIResponse;
import org.virtualizat.one.auth.dto.UserDto;
import org.virtualizat.one.auth.service.ServiceResponse;
import org.virtualizat.one.auth.service.UserService;

import java.util.List;

@RestController
@RequestMapping(value="/users")
public class UserController {

    @Autowired
    UserService userService;


    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody UserDto createUser){

        ServiceResponse<UserDto> userDto = userService.createUser(createUser);

        APIResponse<UserDto> responseDTO = APIResponse
                .<UserDto>builder()
                .status(userDto.getMessageCode())
                .results(userDto.getEntity())
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<?> updateUser(@PathVariable String id, @RequestBody UserDto userRequest){

        ServiceResponse<UserDto> userDto = userService.updateUser(id, userRequest);

        APIResponse<UserDto> responseDTO = APIResponse
                .<UserDto>builder()
                .status(userDto.getMessageCode())
                .results(userDto.getEntity())
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable String id){

        ServiceResponse<UserDto> userDto = userService.deleteUser(id);

        APIResponse<UserDto> responseDTO = APIResponse
                .<UserDto>builder()
                .status(userDto.getMessageCode())
                .results(userDto.getEntity())
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
    }

    @GetMapping
    public ResponseEntity<?> listUser(){

        ServiceResponse<List<UserDto>> users = userService.getUsers();

        APIResponse<List<UserDto>> responseDTO = APIResponse
                .<List<UserDto>>builder()
                .status(users.getMessageCode())
                .results(users.getEntity())
                .build();

        return ResponseEntity.status(HttpStatus.FOUND).body(responseDTO);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<?> getUser(@PathVariable String id){
        ServiceResponse<UserDto> user = userService.getUser(id);

        APIResponse<UserDto> responseDTO = APIResponse
                .<UserDto>builder()
                .status(user.getMessageCode())
                .results(user.getEntity())
                .build();

        return ResponseEntity.status(HttpStatus.FOUND).body(responseDTO);

    }
}

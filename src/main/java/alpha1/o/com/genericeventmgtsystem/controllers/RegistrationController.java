package alpha1.o.com.genericeventmgtsystem.controllers;

import alpha1.o.com.genericeventmgtsystem.common.Routes;
import alpha1.o.com.genericeventmgtsystem.dto.UserDto;
import alpha1.o.com.genericeventmgtsystem.services.UserService;
import alpha1.o.com.genericeventmgtsystem.utils.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Routes.V1_BASE_PATH)
public class RegistrationController {
    @Autowired
    private UserService userService;

    // create a new user
    @PostMapping("/user")
    public ResponseEntity<UserDto> createUser(@Validated @RequestBody UserDto userDto) {
        UserDto createUserDto = this.userService.createUser(userDto);
        return (new ResponseEntity<>(createUserDto, HttpStatus.CREATED));
    }

    // Get All User
    @GetMapping("/users")

    public ResponseEntity<List<UserDto>> getAllUser() {
        return (ResponseEntity.ok(userService.getAllUser()));

    }

    //Get user by id
    @GetMapping(value = "/user/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long userId) {
        UserDto userById = userService.getUserById(userId);
        return ResponseEntity.ok(userById);
    }

    // Update User
    @PutMapping("/delUser/{userId}")
    public ResponseEntity<UserDto> updateUser(@Validated @RequestBody UserDto userDto, @PathVariable Long userId) {
        UserDto updateUser = this.userService.updateUser(userDto, userId);
        return ResponseEntity.ok(updateUser);
    }

    //Delete User
    @DeleteMapping("/user/{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable Long userId) {
        this.userService.deleteUser(userId);
        return new ResponseEntity<>(new ApiResponse("user Deleted Succesfully", true), HttpStatus.ACCEPTED);
    }

}

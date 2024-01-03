package alpha1.o.com.genericeventmgtsystem.controllers;

import alpha1.o.com.genericeventmgtsystem.common.Routes;
import alpha1.o.com.genericeventmgtsystem.dto.UserDto;
import alpha1.o.com.genericeventmgtsystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Routes.V1_BASE_PATH + "/user")
public class RegistrationController {
    @Autowired
    private UserService userService;

    // create a new user
    @PostMapping("/create")
    public ResponseEntity<UserDto> createUser(@Validated @RequestBody UserDto userDto) {
        UserDto createUserDto = this.userService.createUser(userDto);
        return (new ResponseEntity<>(createUserDto, HttpStatus.CREATED));
    }

}

package alpha1.o.com.genericeventmgtsystem.services;


import alpha1.o.com.genericeventmgtsystem.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface UserService {

    UserDto createUser(UserDto user);

    UserDto updateUser(UserDto user, Long userId);

    UserDto getUserById(Long userId);

    List<UserDto> getAllUser();

    void deleteUser(Long userID);


}
package alpha1.o.com.genericeventmgtsystem.services.implementation;

import alpha1.o.com.genericeventmgtsystem.dto.UserDto;
import alpha1.o.com.genericeventmgtsystem.models.User;
import alpha1.o.com.genericeventmgtsystem.repository.UserRepository;
import alpha1.o.com.genericeventmgtsystem.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepository userRepositery;
    @Override
    public UserDto createUser(UserDto userDto) {
        User user = this.dtoToUser(userDto);
        User savedUser = this.userRepositery.save(user);
        return this.userTodto(savedUser);
    }


    //Model Mapper
    private User dtoToUser(UserDto userDto) {
        User user = this.modelMapper.map(userDto, User.class);
        return user;
    }

    public UserDto userTodto(User user) {
        UserDto userDto = this.modelMapper.map(user, UserDto.class);
        return userDto;
    }
}

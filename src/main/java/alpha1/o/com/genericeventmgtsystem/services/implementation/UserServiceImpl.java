package alpha1.o.com.genericeventmgtsystem.services.implementation;

import alpha1.o.com.genericeventmgtsystem.common.AppConstants;
import alpha1.o.com.genericeventmgtsystem.dto.UserDto;
import alpha1.o.com.genericeventmgtsystem.exceptions.ApiRequestException;
import alpha1.o.com.genericeventmgtsystem.models.Address;
import alpha1.o.com.genericeventmgtsystem.models.User;
import alpha1.o.com.genericeventmgtsystem.repository.UserRepository;
import alpha1.o.com.genericeventmgtsystem.services.UserService;
import alpha1.o.com.genericeventmgtsystem.utils.Validation;
import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;
    private Address address;


    @Override
    // Create a new User
    public UserDto createUser(UserDto userDto) {

        if (userDto == null || StringUtils.isEmpty(userDto.getUsername()) || StringUtils.isEmpty(userDto.getEmail())) {
            throw new ApiRequestException("Username and email are required in the request body");
        }
        if (!Validation.isValidEmail(userDto.getEmail())) {
            throw new ApiRequestException("Invalid email format");
        }

        // Validation for username format
        if (!Validation.isValidUsername(userDto.getUsername())) {
            throw new ApiRequestException("Invalid username format");
        }
        // Check if a user with the same username already exists
        if (userRepository.existsByUsername(userDto.getUsername())) {
            throw new ApiRequestException("User with the given username already exists");
        }

        // Check if a user with the same email already exists
        if (userRepository.existsByEmail(userDto.getEmail())) {
            throw new ApiRequestException("User with the given email already exists");
        }
        // Validation for description length
        // Validation for description word count
        if (userDto.getDescription() != null) {
            int wordCount = userDto.getDescription().split("\\s+").length;
            if (wordCount > 50) {
                throw new ApiRequestException("Description must not exceed 50 words");
            }
        }


        User user = this.dtoToUser(userDto);

        User savedUser = this.userRepository.save(user);

        return this.userTodto(savedUser);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Long userId) {
        if (userDto == null || StringUtils.isEmpty(userDto.getFirstName()) || StringUtils.isEmpty(userDto.getLastName())) {
            throw new ApiRequestException("first name and lastName are required in the request body");
        }
        User user = this.userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User Not found"));
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        User updateUser = this.userRepository.save(user);
        return this.userTodto(updateUser);

    }

    @Override
    public UserDto getUserById(Long userId) {
        User user = this.userRepository.findById(userId).orElseThrow(() -> new ApiRequestException("User Not Found"));
        return this.userTodto(user);
    }

    @Override
    public List<UserDto> getAllUser() {
        List<User> users = (List<User>) this.userRepository.findAll();

        List<UserDto> userDtos = new ArrayList<>();
        for (User user : users) {
            UserDto userDto = this.userTodto(user);
            userDtos.add(userDto);
        }
        return userDtos;
    }

    @Override
    public void deleteUser(Long userID) {
        User user = this.userRepository.findById(userID).orElseThrow(() -> new ApiRequestException("user not found "));
        this.userRepository.delete(user);
    }

    @Override
    public boolean publishUserId(String Id) {
        kafkaTemplate.send(AppConstants.NOTIFY_ATTENDEE, Id);
        return true;
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

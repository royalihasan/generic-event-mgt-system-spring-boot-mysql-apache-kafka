package alpha1.o.com.genericeventmgtsystem.services;


import alpha1.o.com.genericeventmgtsystem.dto.UserDto;
import alpha1.o.com.genericeventmgtsystem.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;



@Service
public interface UserService {

    UserDto createUser(UserDto user);




}
package alpha1.o.com.genericeventmgtsystem.services;

import alpha1.o.com.genericeventmgtsystem.common.AppConstants;
import alpha1.o.com.genericeventmgtsystem.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KafkaMessageService {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    @Autowired
    private UserService userService;


    public boolean sendAllUserIds() {
        // Fetch all users
        List<UserDto> users = userService.getAllUser();

        // Extract user IDs and send to Kafka
        for (UserDto user : users) {
            String userId = String.valueOf(user.getUserIdNumber());
            kafkaTemplate.send(AppConstants.NOTIFY_ATTENDEE, userId);
        }
        return true;
    }

    // Other methods in KafkaMessageService
}

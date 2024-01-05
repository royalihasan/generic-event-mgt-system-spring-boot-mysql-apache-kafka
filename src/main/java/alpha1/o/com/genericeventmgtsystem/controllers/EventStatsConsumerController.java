package alpha1.o.com.genericeventmgtsystem.controllers;

import alpha1.o.com.genericeventmgtsystem.common.AppConstants;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class EventStatsConsumerController {
    @KafkaListener(topics = AppConstants.NOTIFY_ATTENDEE, groupId = "user-group")
    public void consumeUsersId(String userIds) {
        System.out.println(userIds);
    }
}

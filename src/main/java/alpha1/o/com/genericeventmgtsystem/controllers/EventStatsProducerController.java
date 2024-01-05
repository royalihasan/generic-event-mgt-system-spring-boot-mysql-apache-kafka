package alpha1.o.com.genericeventmgtsystem.controllers;

import alpha1.o.com.genericeventmgtsystem.common.Routes;
import alpha1.o.com.genericeventmgtsystem.services.KafkaMessageService;
import alpha1.o.com.genericeventmgtsystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(Routes.V1_BASE_PATH)
public class EventStatsProducerController {
    @Autowired
    private UserService userService;
    @Autowired
    private KafkaMessageService kafkaMessageService;

    // Business Logic
    @PutMapping("user-stats")
    public ResponseEntity updateStats() throws InterruptedException {
        System.out.println(kafkaMessageService.sendAllUserIds());

        return new ResponseEntity<>(Map.of("user", kafkaMessageService.sendAllUserIds()), HttpStatus.OK);
    }
}

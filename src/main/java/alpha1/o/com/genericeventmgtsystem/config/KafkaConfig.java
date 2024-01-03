package alpha1.o.com.genericeventmgtsystem.config;

import alpha1.o.com.genericeventmgtsystem.common.AppConstants;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {
    @Bean
    public NewTopic topic(){
        return TopicBuilder.name(AppConstants.NOTIFY_ATTENDEE).build();
    }
}

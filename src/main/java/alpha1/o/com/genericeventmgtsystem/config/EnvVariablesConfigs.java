package alpha1.o.com.genericeventmgtsystem.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "env")
public class EnvVariablesConfigs {
    @Value("${realmName:EventManagementSystem}")
    private String realmName;
}

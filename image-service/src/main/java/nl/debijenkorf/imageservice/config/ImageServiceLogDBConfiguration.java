package nl.debijenkorf.imageservice.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties
@Getter
public class ImageServiceLogDBConfiguration {

    @Value("${logdb.endpoint}")
    private String logDbEndpoint;

    @Value("${logdb.name}")
    private String logDbName;

    @Value("${logdb.username}")
    private String logDbUsername;

    @Value("${logdb.password}")
    private String logDbPassword;
}

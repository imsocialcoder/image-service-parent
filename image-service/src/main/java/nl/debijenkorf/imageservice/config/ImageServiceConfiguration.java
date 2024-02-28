package nl.debijenkorf.imageservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application-${spring.profiles.active}.properties")
public class ImageServiceConfiguration {

    @Value("${source.root.url}")
    private String sourceRootUrl;

    @Value("${aws.s3.endpoint}")
    private String awsS3Endpoint;

    @Value("${aws.accesskey}")
    private String awsAccessKey;

    @Value("${aws.secretkey}")
    private String awsSecretKey;

    @Value("${logdb.endpoint}")
    private String logDbEndpoint;

    @Value("${logdb.name}")
    private String logDbName;

    @Value("${logdb.username}")
    private String logDbUsername;

    @Value("${logdb.password}")
    private String logDbPassword;

    @Bean
    public String sourceRootUrl() {
        return sourceRootUrl;
    }

    @Bean
    public String awsS3Endpoint() {
        return awsS3Endpoint;
    }

    @Bean
    public String awsAccessKey() {
        return awsAccessKey;
    }

    @Bean
    public String awsSecretKey() {
        return awsSecretKey;
    }

    @Bean
    public String logDbEndpoint() {
        return logDbEndpoint;
    }

    @Bean
    public String logDbName() {
        return logDbName;
    }

    @Bean
    public String logDbUsername() {
        return logDbUsername;
    }

    @Bean
    public String logDbPassword() {
        return logDbPassword;
    }
}
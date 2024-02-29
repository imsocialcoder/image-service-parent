package nl.debijenkorf.imageservice.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties
@Getter
public class ImageServiceAWSConfiguration {

    @Value("${aws.s3.endpoint}")
    private String awsS3Endpoint;

    @Value("${aws.s3.accesskey}")
    private String awsS3AccessKey;

    @Value("${aws.s3.secretkey}")
    private String awsS3SecretKey;

}

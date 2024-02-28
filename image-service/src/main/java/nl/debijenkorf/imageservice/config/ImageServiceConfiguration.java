package nl.debijenkorf.imageservice.config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties
public class ImageServiceConfiguration {

    @Value("${source.root.url}")
    private String sourceRootUrl;

    @Value("${aws.s3.endpoint}")
    private String awsS3Endpoint;

    @Value("${aws.s3.accesskey}")
    private String awsAccessKey;

    @Value("${aws.s3.secretkey}")
    private String awsSecretKey;

    @Value("${logdb.endpoint}")
    private String logDbEndpoint;

    @Value("${logdb.name}")
    private String logDbName;

    @Value("${logdb.username}")
    private String logDbUsername;

    @Value("${logdb.password}")
    private String logDbPassword;

    public String getSourceRootUrl() {
        return sourceRootUrl;
    }

    public String getAwsS3Endpoint() {
        return awsS3Endpoint;
    }

    public String getAwsAccessKey() {
        return awsAccessKey;
    }

    public String getAwsSecretKey() {
        return awsSecretKey;
    }

    public String getLogDbEndpoint() {
        return logDbEndpoint;
    }

    public String getLogDbName() {
        return logDbName;
    }

    public String getLogDbUsername() {
        return logDbUsername;
    }

    public String getLogDbPassword() {
        return logDbPassword;
    }
}

package nl.debijenkorf.imageservice.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties
@Getter
public class ImageServiceDownloadConfiguration {

    @Value("${source.root.url}")
    private String sourceRootUrl;
}

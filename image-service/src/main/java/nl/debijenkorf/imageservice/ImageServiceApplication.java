package nl.debijenkorf.imageservice;

import nl.debijenkorf.imageservice.config.ImageServiceConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
public class ImageServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImageServiceApplication.class, args);
	}

}

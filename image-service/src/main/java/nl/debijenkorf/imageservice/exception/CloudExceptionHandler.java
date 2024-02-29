package nl.debijenkorf.imageservice.exception;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
@Profile("!local")
public class CloudExceptionHandler {
}

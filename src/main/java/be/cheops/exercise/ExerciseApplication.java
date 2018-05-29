package be.cheops.exercise;

import org.slf4j.Logger;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static org.slf4j.LoggerFactory.getLogger;

@SpringBootApplication
public class ExerciseApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExerciseApplication.class, args);
    }

    @Bean
    Logger logger(InjectionPoint injectionPoint) {
        return getLogger(injectionPoint.getMethodParameter().getContainingClass());
    }

}

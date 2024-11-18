package org.example.eventpublish;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

@SpringBootApplication
@Slf4j
public class EventpublishApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(EventpublishApplication.class);
        springApplication.addListeners(
                (ApplicationListener<ApplicationReadyEvent>) event -> log.info("Application ready! {} ",event));
        springApplication.run(args);
    }

}

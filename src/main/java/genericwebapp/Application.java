package genericwebapp;

import java.io.IOException;

import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;

import genericwebapp.event.SystemMemoryEvent;
import genericwebapp.log.Log;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class Application implements ApplicationListener<ApplicationReadyEvent> {

    @Log
    private Logger log;

    public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        log.info("ApplicationReadyEvent fired...");
    }

    @EventListener
    public void eventListener(SystemMemoryEvent event) throws IOException {
        log.info(event.toString());
    }

    public static class Const {

		public static final String CHARTJS_VERSION = "https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.1/Chart.bundle.min.js";
	}
}

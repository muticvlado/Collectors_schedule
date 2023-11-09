package vlado.collectors_schedule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class CollectorsScheduleApplication {

	public static void main(String[] args) {
		SpringApplication.run(CollectorsScheduleApplication.class, args);
	}
}

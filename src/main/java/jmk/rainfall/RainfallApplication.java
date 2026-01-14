package jmk.rainfall;

import jmk.rainfall.config.KmaProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(KmaProperties.class)
public class RainfallApplication {

	public static void main(String[] args) {
		SpringApplication.run(RainfallApplication.class, args);
	}

}

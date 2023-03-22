package in.mk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
@CrossOrigin("*")
public class ArApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArApiApplication.class, args);
	}

}

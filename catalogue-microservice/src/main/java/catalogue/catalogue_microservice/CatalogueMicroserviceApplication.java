package catalogue.catalogue_microservice;

import catalogue.catalogue_microservice.entity.Order;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class CatalogueMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatalogueMicroserviceApplication.class, args);
	}

}

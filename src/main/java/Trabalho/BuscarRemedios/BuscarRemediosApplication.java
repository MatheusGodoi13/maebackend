package Trabalho.BuscarRemedios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EntityScan("Trabalho.BuscarRemedios.model")
@EnableJpaRepositories(basePackages = "Trabalho.BuscarRemedios.Repository")
public class BuscarRemediosApplication {
	public static void main(String[] args) {
		SpringApplication.run(BuscarRemediosApplication.class, args);
			System.out.println("Buscando");
		}
		
	}

package com.sistemaexamenesbackend.sistemaexamenes;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com/sistemaexamenesbackend/sistemaexamenes/entitys")
public class SistemaExamenesApplication  {
	public static void main(String[] args) {

		SpringApplication.run(SistemaExamenesApplication.class, args);
	}


}
